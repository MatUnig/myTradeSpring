package com.trading.web;

import com.trading.entity.Transaction;
import com.trading.entity.User;
import com.trading.repository.CurrencyRespository;
import com.trading.service.CurrentUser;
import com.trading.service.TransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.trading.repository.UserRepository;
import com.trading.service.UserService;
import com.trading.utils.Function;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class TransController {

    @Autowired
    public UserRepository userRepository;
    @Autowired
    public TransService transService;
    @Autowired
    public UserService userService;
    @Autowired
    public CurrencyRespository currencyRespository;

    @RequestMapping(value = "/pickProduct", method = RequestMethod.GET)
    public ModelAndView addUser(HttpServletRequest request, @ModelAttribute("transaction") Transaction transaction) throws IOException {
        ModelAndView mav = new ModelAndView("product");
        String fromCurrency = request.getParameter("fromCurrency");
        String toCurrency = request.getParameter("toCurrency");
        String product = Function.parseNames(fromCurrency, toCurrency);
        double price = Function.parsePrice(fromCurrency, toCurrency);
        mav.addObject("fromCurrency", fromCurrency);
        mav.addObject("toCurrency", toCurrency);
        mav.addObject("product", product);
        mav.addObject("price", price);
        return mav;
    }

    @RequestMapping(value = "/buyProduct", method = RequestMethod.POST)
    public String buyProduct(@AuthenticationPrincipal CurrentUser customUser, HttpServletRequest request,
                             @ModelAttribute("transaction") Transaction transaction, Model model) throws IOException {
        User currentUser = customUser.getUser();
        model.addAttribute("firstname", currentUser.getName());
        model.addAttribute("balance", currentUser.getBalance());
        model.addAttribute("list", currencyRespository.findAll());
        if (0.8 * currentUser.getBalance() < Double.parseDouble(request.getParameter("quantity")) * Double.parseDouble(request.getParameter("price"))){
            model.addAttribute("lowBalance", "This transaction is over the margin. Try lower amount.");
            return "welcome";
        }
        else {
            transService.buy(customUser, transaction, request);
            model.addAttribute("gzBuy", "You have bought " + transaction.getProduct() + " with price " + transaction.getPrice());
            return "welcome";
        }
    }

    @RequestMapping(value = "/showTrans", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView showTrans(@AuthenticationPrincipal CurrentUser customUser, Model model) throws IOException {
        List<Transaction> trans = transService.getTrans(customUser);
        ModelAndView mav = new ModelAndView("transactions");
        double profitSum=0;
        for (Transaction t : trans){
            if (!t.getStatus().equals("Closed")) {
                Function.setCurrentPrice(t);
                Function.setProfit(t);
                profitSum += t.getProfit() + t.getBookedProfit();
            }
        }
        model.addAttribute("trans",trans);
        User currentUser = customUser.getUser();
        double balance = Math.round((currentUser.getBalance() + profitSum)*100.0)/100.0;
        currentUser.setBalance(balance);
        userRepository.save(currentUser);
        return mav;
    }
    @RequestMapping(value = "/close", method = RequestMethod.POST)
    public String closeTrans(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("close"));
        Transaction trans = transService.findById(id);
        trans.setStatus("Closed");
        Function.setProfitResult(trans);
        transService.applyChanges(trans);
        return "redirect:/showTrans";
    }

    @RequestMapping(value = "/return", method = RequestMethod.GET)
    public String returnToMain(@AuthenticationPrincipal CurrentUser customUser, Model model) throws IOException {
        User currentUser = customUser.getUser();
        model.addAttribute("firstname", currentUser.getName());
        model.addAttribute("balance",currentUser.getBalance());
        model.addAttribute("list", currencyRespository.findAll());
        return "welcome";
    }

}


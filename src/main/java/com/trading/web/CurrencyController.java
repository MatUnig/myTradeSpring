package com.trading.web;

import com.trading.entity.Currency;
import com.trading.repository.CurrencyRespository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.trading.dao.CurrencyDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class CurrencyController {

    private final CurrencyRespository currencyRespository;
    private final CurrencyDao currencyDao;

    public CurrencyController(CurrencyRespository currencyRespository, CurrencyDao currencyDao) {
        this.currencyRespository = currencyRespository;
        this.currencyDao = currencyDao;
    }

    @GetMapping("/add-currency")
    public String addCurrency(Model model){
        model.addAttribute("currency", new Currency());
        return "admin/addCurrency";
    }

    @PostMapping("/add-currency")
    public String addCurencyPerform(@ModelAttribute Currency currency, Model model){
        currencyDao.save(currency);
        model.addAttribute("success", "You have added a new currency.");
        return "admin/addCurrency";
    }
    @GetMapping("/currencies")
    @ResponseBody
    public ModelAndView updateCurrency() {
        ModelAndView mav = new ModelAndView("admin/currencies");
        mav.addObject("currencies",currencyRespository.findAll());
        return mav;
    }
    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String removeCurrency(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("close"));
        currencyRespository.delete(id);
        return "redirect:/currencies";
    }
}
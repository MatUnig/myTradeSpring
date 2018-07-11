package com.trading.web;

import com.trading.entity.Currency;
import com.trading.repository.CurrencyRespository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class CurrencyController {

    private final CurrencyRespository currencyRespository;

    public CurrencyController(CurrencyRespository currencyRespository) {
        this.currencyRespository = currencyRespository;
    }

    @GetMapping("/add-currency")
    public String addCurrency(Model model){
        model.addAttribute("currency", new Currency());
        return "admin/addCurrency";
    }

    @PostMapping("/add-currency")
    public String addCurencyPerform(@ModelAttribute Currency currency, Model model){
        currencyRespository.save(currency);
        model.addAttribute("success", "You have added a new currency.");
        return "admin/addCurrency";
    }
    @GetMapping("/currencies")
    public String updateCurrency(Model model) {
        model.addAttribute("currencies",currencyRespository.findAll());
        return "admin/currencies";
    }
    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String removeCurrency(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("close"));
        currencyRespository.delete(id);
        return "redirect:/currencies";
    }
}
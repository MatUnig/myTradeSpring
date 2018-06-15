package com.trading.web;


import com.trading.entity.User;
import com.trading.repository.CurrencyRespository;
import com.trading.service.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.trading.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class LoginController {
    @Autowired
    CurrencyRespository currencyRespository;

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = {"/admin"}, method = RequestMethod.GET)
    public ModelAndView adminPage(@AuthenticationPrincipal CurrentUser customUser) {
        ModelAndView model = new ModelAndView();
        model.setViewName("admin/admin");
        User currentUser = customUser.getUser();
        System.out.println(currentUser);
        model.addObject("firstname", currentUser.getName());
        model.addObject("balance", currentUser.getBalance());
        model.addObject("roles", currentUser.getRoles().toString());
        return model;
    }

    @RequestMapping(value = {"/add-user"}, method = RequestMethod.GET)
    public void createUser() {
        User user = new User();
        user.setPassword("user");
        user.setUsername("user");
        userService.saveUser(user);
    }

    @RequestMapping(value = {"/homePage"}, method = RequestMethod.GET)
    public ModelAndView homePage(@AuthenticationPrincipal CurrentUser customUser) {
        ModelAndView model = new ModelAndView();
        model.setViewName("welcome");
        User currentUser = customUser.getUser();
        System.out.println(currentUser);
        model.addObject("firstname", currentUser.getName());
        model.addObject("balance", currentUser.getBalance());
        model.addObject("list", currencyRespository.findAll());
        return model;
    }
    @RequestMapping(value = "/picker", method = RequestMethod.GET)
    public ModelAndView pickProduct() throws IOException {
        ModelAndView mav = new ModelAndView("picker");
        mav.addObject("list", currencyRespository.findAll());
        return mav;
    }

    @RequestMapping(value = "/loginPage", method = RequestMethod.GET)
    public ModelAndView loginPage(@RequestParam(value = "error", required = false) String error,
                                  @RequestParam(value = "logout", required = false) String logout) {
        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid login or password.");
        }

        if (logout != null) {
            model.addObject("message", "Logged out from myTrade successfully.");
        }
        model.setViewName("loginPage");
        return model;
    }
    @RequestMapping(value = "/log", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        return "logout";
    }


}

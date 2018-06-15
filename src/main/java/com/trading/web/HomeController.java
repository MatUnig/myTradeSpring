package com.trading.web;

import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {


    @GetMapping("/")
    public String hello(){
        return "home";
    }

    @GetMapping("/calendar")
    public String calendar(){
        return "calendar";
    }

    @GetMapping("/techTrade")
    public String techTrade(){
        return "techTrade";
    }

//    @RequestMapping(value = {"/error"}, method = RequestMethod.GET)
//    public String handleError() {
//        return "error";
//    }
//    @Override
//    public String getErrorPath() {
//        return "/error";
//    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public String handleResourceNotFoundException() {
        return "error";
    }
}

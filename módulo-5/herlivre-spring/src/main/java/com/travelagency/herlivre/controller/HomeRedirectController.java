package com.travelagency.herlivre.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeRedirectController {
    @GetMapping(path = {"","/","/login"})
    public String home(){
        return "redirect:/pages/home";
    }
}

package com.travelagency.herlivre.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/admin")
public class AdminController {
    @GetMapping(path = "/dashboard")
    public String dashboard(){
        return "admin/dashboard";
    }
}

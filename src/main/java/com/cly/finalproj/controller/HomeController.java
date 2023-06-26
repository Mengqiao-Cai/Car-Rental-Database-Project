package com.cly.finalproj.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {





    @GetMapping(value = "/home")
    public String getHome(Model model){

        return "index";
    }

}

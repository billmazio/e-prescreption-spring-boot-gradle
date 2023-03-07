package com.example.prescription.controller;

import org.springframework.stereotype.Controller;

@Controller
public class HomeController {

    public String showHomePage() {
        return "index";
    }


}
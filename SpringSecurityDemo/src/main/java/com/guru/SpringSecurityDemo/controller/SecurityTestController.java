package com.guru.SpringSecurityDemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityTestController {

    @GetMapping("/welcome")
    public String getWelcomeMesg(){
        return "welcome";
    }

    @GetMapping("/contact")
    public String getContactDetails(){
        return "Hyederabad";
    }

}

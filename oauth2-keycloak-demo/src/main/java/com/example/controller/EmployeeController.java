package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @GetMapping("/public")
    public String publicApi() {
        return "Public API";
    }

    @GetMapping("/user")
    public String user() {
        return "User API";
    }

    @GetMapping("/admin")
    public String admin() {
        return "Admin API";
    }
}

package com.devrection.testsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginConroller {

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
}

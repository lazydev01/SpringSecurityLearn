package com.springsecurity.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class SignInController {

    @GetMapping("/signIn")
    public String signIn(){
        return "login.html";
    }
}

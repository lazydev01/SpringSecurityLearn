package com.springsecurity.learn.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {
    @GetMapping("")
    public String home(){
        return "This is Home Page";
    }
    @GetMapping("/register")
    public String register(){
        return "This is Register Page";
    }
    @GetMapping("/login.html")
    public String login(){
        return "This is Login Page";
    }
}

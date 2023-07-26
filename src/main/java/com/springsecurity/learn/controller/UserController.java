package com.springsecurity.learn.controller;

import com.springsecurity.learn.model.User;
import com.springsecurity.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    public List<User> getAllUsers(){
        return this.userService.getAllUsers();
    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable String username){
        return this.userService.getUserByUsername(username);
    }

    @PostMapping("/")
    public User addUser(@RequestBody User user){
        return this.userService.addUser(user);
    }

}

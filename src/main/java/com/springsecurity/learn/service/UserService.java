package com.springsecurity.learn.service;

import com.springsecurity.learn.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    List<User> users = new ArrayList<>();

    public UserService() {
        users.add(new User("abc", "abc@test.com", "abc"));
        users.add(new User("def", "def@test.com", "def"));
        users.add(new User("ghi", "ghi@test.com", "ghi"));
    }

    public List<User> getAllUsers(){
        return this.users;
    }

    public User getUserByUsername(String username){
        return this.users.stream().filter((user)-> user.getUsername().equals(username)).findAny().orElse(null);
    }

    public User addUser(User user){
        this.users.add(user);
        return user;
    }
}

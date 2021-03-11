package com.example.mobile.app.ws.ui.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {
    @GetMapping
    public String getUser(){
        return "get user was called";
    }

    @PostMapping
    public String createUser(){
        return "Create user was called";
    }

    @PutMapping
    public  String updateUser(){
        return "update Usr was called";
    }

    @DeleteMapping
    public String deleteUser(){
        return "delete User was called";
    }
}

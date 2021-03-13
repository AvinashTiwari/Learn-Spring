package com.example.mobile.app.ws.ui.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {
    @GetMapping(path="/{userId}")
    public String getUser(@PathVariable String userId){
        return "get user was userrid " + userId;
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

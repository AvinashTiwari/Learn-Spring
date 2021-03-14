package com.example.mobile.app.ws.ui.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {
    @GetMapping()
    public String getUsers(@RequestParam(value="page") int page,
                           @RequestParam(value="limit") int limit){
        return "get users was called with page " +page+ " limit " +limit ;
    }


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

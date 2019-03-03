package com.itemsharning.userservice.controller;

import com.itemsharning.userservice.model.User;
import com.itemsharning.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/{username}")
    public User getUserByUserName(@PathVariable String username){
        return userService.getUserByName(username);
    }
}

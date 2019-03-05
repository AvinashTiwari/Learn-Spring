package com.itemsharning.userservice.controller;

import com.itemsharning.userservice.model.User;
import com.itemsharning.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/{username}")
    public User getUserByUserName(@PathVariable String username){
        return userService.getUserByName(username);
    }

    @RequestMapping(method = RequestMethod.POST)
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }
}

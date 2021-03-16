package com.example.mobile.app.ws.ui.controller;

import com.example.mobile.app.ws.ui.model.response.UserRest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {
    @GetMapping()
    public String getUsers(@RequestParam(value="page", defaultValue = "1") int page,
                           @RequestParam(value="limit", defaultValue = "50") int limit,
                           @RequestParam(value="sort", defaultValue = "desc", required = false) String sort){
        return "get users was called with page " +page+ " limit " +limit ;
    }


    @GetMapping(path="/{userId}")
    public UserRest getUser(@PathVariable String userId){

        UserRest returnValue = new UserRest();
        returnValue.setFirstName("Avinash");
        returnValue.setLastName("Tiwari");
        returnValue.setEmailId("test@test.com");
        return  returnValue;
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

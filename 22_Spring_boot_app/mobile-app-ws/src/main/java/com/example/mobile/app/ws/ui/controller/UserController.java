package com.example.mobile.app.ws.ui.controller;

import com.example.mobile.app.ws.ui.model.request.UpdateUserDetailsRequestModel;
import com.example.mobile.app.ws.ui.model.request.UserDetailsRequestModel;
import com.example.mobile.app.ws.ui.model.response.UserRest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@RestController
@RequestMapping("users")
public class UserController {
    Map<String, UserRest> users;
    @GetMapping()
    public String getUsers(@RequestParam(value="page", defaultValue = "1") int page,
                           @RequestParam(value="limit", defaultValue = "50") int limit,
                           @RequestParam(value="sort", defaultValue = "desc", required = false) String sort){
        return "get users was called with page " +page+ " limit " +limit ;
    }


    @GetMapping(path="/{userId}", produces ={MediaType.APPLICATION_XML_VALUE,
                                             MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> getUser(@PathVariable String userId){
/*
        UserRest returnValue = new UserRest();
        returnValue.setFirstName("Avinash");
        returnValue.setLastName("Tiwari");
        returnValue.setEmailId("test@test.com");
        */

        String firstName = null;
        int firstNameLength = firstName.length();

        if(users.containsKey(userId)){
            return  new ResponseEntity<>(users.get(userId),HttpStatus.OK);
        }else
        {
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }


    }

    @PostMapping( consumes ={MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE},  produces ={MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE})
    public  ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails){
        UserRest returnValue = new UserRest();
        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setLastName(userDetails.getLastName());
        returnValue.setEmailId(userDetails.getEmail());
        String userId = UUID.randomUUID().toString();
        returnValue.setUserId(userId);
        if(users == null){
            users = new HashMap<>();
            users.put(userId,returnValue);
        }
        return  new ResponseEntity<>(returnValue,HttpStatus.OK);
    }

    @PutMapping(consumes ={MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE},  produces ={MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE},path="/{userId}")
    public  UserRest updateUser(@PathVariable String userId,@Valid @RequestBody UpdateUserDetailsRequestModel userDetails){
        UserRest storedUserdetails = users.get(userId);
        storedUserdetails.setFirstName(userDetails.getFirstName());
        storedUserdetails.setLastName(userDetails.getLastName());
        users.put(userId, storedUserdetails);
        return storedUserdetails;
    }

    @DeleteMapping(path="/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId){

        users.remove(userId);
        return ResponseEntity.noContent().build();
    }
}

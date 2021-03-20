package com.example.mobile.app.ws.ui.controller;

import com.example.mobile.app.ws.ui.model.request.UserDetailsRequestModel;
import com.example.mobile.app.ws.ui.model.response.UserRest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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


    @GetMapping(path="/{userId}", produces ={MediaType.APPLICATION_XML_VALUE,
                                             MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> getUser(@PathVariable String userId){

        UserRest returnValue = new UserRest();
        returnValue.setFirstName("Avinash");
        returnValue.setLastName("Tiwari");
        returnValue.setEmailId("test@test.com");
        return  new ResponseEntity<>(returnValue,HttpStatus.OK);
    }

    @PostMapping( consumes ={MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE},  produces ={MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE})
    public  ResponseEntity<UserRest> createUser(@RequestBody UserDetailsRequestModel userDetails){
        UserRest returnValue = new UserRest();
        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setLastName(userDetails.getLastName());
        returnValue.setEmailId(userDetails.getEmail());
        return  new ResponseEntity<>(returnValue,HttpStatus.OK);
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

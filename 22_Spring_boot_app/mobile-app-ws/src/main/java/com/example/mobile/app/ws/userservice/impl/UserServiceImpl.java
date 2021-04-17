package com.example.mobile.app.ws.userservice.impl;

import com.example.mobile.app.ws.shared.Utils;
import com.example.mobile.app.ws.ui.model.request.UserDetailsRequestModel;
import com.example.mobile.app.ws.ui.model.response.UserRest;
import com.example.mobile.app.ws.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserServiceImpl implements UserService {

    Map<String, UserRest> users;
    Utils utils;

    @Autowired
    UserServiceImpl (Utils utils){
        this.utils = utils;
    }

    @Override
    public UserRest createUser(UserDetailsRequestModel userDetails) {

        UserRest returnValue = new UserRest();
        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setLastName(userDetails.getLastName());
        returnValue.setEmailId(userDetails.getEmail());
        String userId = utils.generateUserId();
        if(users == null){
            users = new HashMap<>();
            users.put(userId,returnValue);
        }

        return returnValue;
    }
}

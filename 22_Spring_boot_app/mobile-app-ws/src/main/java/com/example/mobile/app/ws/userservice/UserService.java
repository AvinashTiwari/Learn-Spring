package com.example.mobile.app.ws.userservice;

import com.example.mobile.app.ws.ui.model.request.UserDetailsRequestModel;
import com.example.mobile.app.ws.ui.model.response.UserRest;

public interface UserService {
    UserRest createUser(UserDetailsRequestModel userDetails);
}

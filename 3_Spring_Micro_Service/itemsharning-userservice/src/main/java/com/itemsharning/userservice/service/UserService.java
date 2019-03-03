package com.itemsharning.userservice.service;

import com.itemsharning.userservice.model.User;

public interface UserService {
    User createUser(User user);
    User getUserByName(String username);

}

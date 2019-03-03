package com.itemsharning.userservice.service.impl;

import com.itemsharning.userservice.model.User;
import com.itemsharning.userservice.repositry.UserRepositry;
import com.itemsharning.userservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepositry userRepositry;

    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public User getUserByName(String username) {
        return userRepositry.findByUsername(username);
    }
}

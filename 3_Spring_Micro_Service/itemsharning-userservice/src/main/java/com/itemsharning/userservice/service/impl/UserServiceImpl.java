package com.itemsharning.userservice.service.impl;

import com.itemsharning.userservice.model.Role;
import com.itemsharning.userservice.model.User;
import com.itemsharning.userservice.model.UserRole;
import com.itemsharning.userservice.repositry.UserRepositry;
import com.itemsharning.userservice.service.UserService;
import org.apache.catalina.security.SecurityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepositry userRepositry;

    @Override
    public User createUser(User user) {

        User localuser = userRepositry.findByUsername(user.getUsername());
        if(localuser !=null){
            LOG.info("User with username found {} ", user.getUsername());
        }else{
            Set<UserRole> userRoles=new HashSet<>();
            Role localRole=new Role();
            localRole.setRoleId(1);
            userRoles.add(new UserRole(user,localRole));
            user.getUserRole().addAll(userRoles);
            Date today= new Date();
            user.setJoinDate(today);

            String encryptedPassword =  SecurityUtili
            user.setPassword(encryptedPassword);
            localuser = userRepositry.save(user);

        }

        return localuser;
    }

    @Override
    public User getUserByName(String username) {
        return userRepositry.findByUsername(username);
    }
}

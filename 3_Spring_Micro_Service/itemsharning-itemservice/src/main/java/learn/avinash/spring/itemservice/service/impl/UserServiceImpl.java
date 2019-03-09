package learn.avinash.spring.itemservice.service.impl;

import learn.avinash.spring.itemservice.model.User;
import learn.avinash.spring.itemservice.repositry.UserRepositry;
import learn.avinash.spring.itemservice.service.UserService;
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
    public User findByUserName(String username) {
        return userRepositry.findByUsername(username);
    }
}

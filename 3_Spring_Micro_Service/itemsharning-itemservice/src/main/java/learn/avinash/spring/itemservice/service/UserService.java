package learn.avinash.spring.itemservice.service;


import learn.avinash.spring.itemservice.model.User;

public interface UserService {

    User findByUserName(String username);

}

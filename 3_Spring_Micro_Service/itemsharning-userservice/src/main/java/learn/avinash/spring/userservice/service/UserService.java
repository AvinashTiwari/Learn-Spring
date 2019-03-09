package learn.avinash.spring.userservice.service;

import learn.avinash.spring.userservice.model.User;

public interface UserService {
    User createUser(User user);
    User getUserByName(String username);

}

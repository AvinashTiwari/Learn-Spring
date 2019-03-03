package com.itemsharning.userservice.repositry;

import com.itemsharning.userservice.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepositry extends CrudRepository<User, Long> {
    User findByUsername(String username);
}

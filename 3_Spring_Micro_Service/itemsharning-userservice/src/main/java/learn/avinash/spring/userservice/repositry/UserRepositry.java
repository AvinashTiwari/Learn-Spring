package learn.avinash.spring.userservice.repositry;

import learn.avinash.spring.userservice.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepositry extends CrudRepository<User, Long> {
    User findByUsername(String username);
}

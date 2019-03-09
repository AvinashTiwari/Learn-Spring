package learn.avinash.spring.itemservice.repositry;


import learn.avinash.spring.itemservice.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepositry extends CrudRepository<User, Long> {
    User findByUsername(String username);
}

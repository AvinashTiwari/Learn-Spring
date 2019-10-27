package learn.avinash.spring.boot.ppmtool.repositories;


import learn.avinash.spring.boot.ppmtool.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {


    User findByUsername(String username);
    User getById(Long id);
}

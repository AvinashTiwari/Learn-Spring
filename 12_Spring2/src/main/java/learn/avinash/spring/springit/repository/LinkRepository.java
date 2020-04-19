package learn.avinash.spring.springit.repository;

import learn.avinash.spring.springit.domain.Link;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<Link,Long> {

}

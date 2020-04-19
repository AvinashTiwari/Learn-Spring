package learn.avinash.spring.springit.repository;


import learn.avinash.spring.springit.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}

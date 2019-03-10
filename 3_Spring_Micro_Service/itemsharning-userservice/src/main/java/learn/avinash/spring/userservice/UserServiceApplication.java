package learn.avinash.spring.userservice;

import learn.avinash.spring.userservice.model.Role;
import learn.avinash.spring.userservice.model.User;
import learn.avinash.spring.userservice.model.UserRole;
import learn.avinash.spring.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class UserServiceApplication implements CommandLineRunner {
    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        User user = new User();
        user.setFirstName("Avinash");
        user.setLastName("Tiwari");
        user.setUsername("ATiwari");
        user.setPassword("password");
        user.setEmail("a@a.com");
        Set<UserRole> userRoles = new HashSet<>();
        Role role = new Role();
        role.setRoleId(1);
        role.setName("ROLE_USER");
        userRoles.add(new UserRole(user, role));
        userService.createUser(user);





    }
}

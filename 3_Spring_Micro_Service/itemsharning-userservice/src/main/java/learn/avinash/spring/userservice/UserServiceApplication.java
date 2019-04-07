package learn.avinash.spring.userservice;

import learn.avinash.spring.userservice.model.Role;
import learn.avinash.spring.userservice.model.User;
import learn.avinash.spring.userservice.model.UserRole;
import learn.avinash.spring.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.sleuth.Sampler;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@EnableEurekaClient
@EnableResourceServer
public class UserServiceApplication implements CommandLineRunner {
    @Bean
    public Sampler defaultSampler(){
        return new AlwaysSampler();
    }

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

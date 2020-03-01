package learn.avinash.spring.springit.runner;

import learn.avinash.spring.springit.domain.Link;
import learn.avinash.spring.springit.repository.CommentRepository;
import learn.avinash.spring.springit.repository.LinkedRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class SomeOtherRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Some Other runner");
    }

}

package learn.avinash.spring.itemservice;

import learn.avinash.spring.itemservice.model.Item;
import learn.avinash.spring.itemservice.model.User;
import learn.avinash.spring.itemservice.service.ItemService;
import learn.avinash.spring.itemservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

import java.util.Date;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@EnableCircuitBreaker
public class ItemServiceApplication implements CommandLineRunner {
    @Autowired
    private ItemService itemService;

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(ItemServiceApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        User user = userService.findByUserName("ATiwari");

        Item item1 = new Item();
        item1.setName("Item1");
        item1.setItemCondition("New");
        item1.setStatus("Active");
        item1.setAddDate(new Date());
        item1.setDescription("This is an item description.");
        item1.setUser(user);

        itemService.addItembyUser(item1, user.getUsername());

        Item item2 = new Item();
        item2.setName("Item2");
        item2.setItemCondition("Used");
        item2.setStatus("Inactive");
        item2.setAddDate(new Date());
        item2.setDescription("This is an item description for item2.");
        item2.setUser(user);

        itemService.addItembyUser(item2, user.getUsername());
    }
}

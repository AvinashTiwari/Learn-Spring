package learn.avinash.spring.itemservice.client;

import learn.avinash.spring.itemservice.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@FeignClient("userservice")
public interface UserFeignClient {

    @RequestMapping(value="/v1/user/{username}", consumes = "application/json")
    User getUserByUsername(@PathVariable("username") String username);
}

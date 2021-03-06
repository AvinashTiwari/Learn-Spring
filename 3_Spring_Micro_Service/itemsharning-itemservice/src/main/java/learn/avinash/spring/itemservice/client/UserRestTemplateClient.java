package learn.avinash.spring.itemservice.client;

import learn.avinash.spring.itemservice.model.User;
import learn.avinash.spring.itemservice.util.UserContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Component;



@Component
public class UserRestTemplateClient {
    @Autowired
    private OAuth2RestTemplate oAuth2RestTemplate;

    private static final Logger logger = LoggerFactory.getLogger(UserRestTemplateClient.class);

    public User getUser(String username) {
        logger.debug("In item service.getUser: {}", UserContextHolder.getContext().getCoorelationId());

        ResponseEntity<User> restExchange = oAuth2RestTemplate.exchange("http://localhost:5555/api/user/v1/user/{username}", HttpMethod.GET, null, User.class, username);

        return restExchange.getBody();
    }
}
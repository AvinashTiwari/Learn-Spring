package learn.avinash.spring.anugular.resfulwebservices.basic;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BasicAuthenticationController {


    @GetMapping( path="/basicauth")
    public AuthenticationBeam HelloWorldBean(){
        return  new AuthenticationBeam("You are Authenticated");
    }


}

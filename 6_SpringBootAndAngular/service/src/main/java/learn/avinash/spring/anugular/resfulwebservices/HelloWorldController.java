package learn.avinash.spring.anugular.resfulwebservices;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HelloWorldController {

    @GetMapping( path="/hello-world")
    public String HelloWorld(){
        return  "Hello World";
    }

    @GetMapping( path="/hello-world-bean")
    public HelloWorldBean HelloWorldBean(){
        return  new HelloWorldBean("Hello World- chaned");
    }

    @GetMapping( path="/hello-world-bean/path-variable/{name}")
    public HelloWorldBean HelloWorldPathVariable(@PathVariable String name){
        return  new HelloWorldBean("Hello World " + name);
    }
}

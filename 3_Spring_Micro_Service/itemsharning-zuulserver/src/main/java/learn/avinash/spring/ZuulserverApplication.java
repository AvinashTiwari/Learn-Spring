package learn.avinash.spring;

import learn.avinash.spring.util.UserContextInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.sleuth.Sampler;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@SpringBootApplication
@EnableZuulProxy
public class ZuulserverApplication {
    @Bean
    public Sampler defaultSampler(){
        return new AlwaysSampler();
    }

    @Bean
    public RestTemplate getRestTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        List interceptor =restTemplate.getInterceptors();

        if(interceptor == null){
            restTemplate.setInterceptors(Collections.singletonList(new UserContextInterceptor()));
        }else{
            interceptor.add(new UserContextInterceptor());
            restTemplate.setInterceptors(interceptor);
        }

        return restTemplate;
    }
    public static void main(String[] args) {
        SpringApplication.run(ZuulserverApplication.class, args);
    }
}

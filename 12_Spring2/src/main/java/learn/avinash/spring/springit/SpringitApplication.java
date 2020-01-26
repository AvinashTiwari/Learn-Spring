package learn.avinash.spring.springit;

import learn.avinash.spring.springit.config.SpringintProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(SpringintProperties.class)
public class SpringitApplication {

	@Autowired
	private SpringintProperties springintProperties;

	public static void main(String[] args) {
		SpringApplication.run(SpringitApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(){
		return  args -> {
			System.out.println("Welcome message " + springintProperties.getWelcome());
		};
	}

}

package learn.avinash.integration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@Configuration
@ImportResource("integration-context.xml")
public class SpringIntegrationCompontentQueueApplication implements ApplicationRunner  {

	public static void main(String[] args) {
		SpringApplication.run(SpringIntegrationCompontentQueueApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		List<Future<Message<String>>> futures = new ArrayList<Future<Message<String>>>();
		
		
	}

}

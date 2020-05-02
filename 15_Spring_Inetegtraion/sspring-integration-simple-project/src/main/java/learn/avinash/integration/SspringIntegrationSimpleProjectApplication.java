package learn.avinash.integration;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;

@SpringBootApplication
@Configuration
@ImportResource("integration-context.xml")
public class SspringIntegrationSimpleProjectApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(SspringIntegrationSimpleProjectApplication.class, args);
	}
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		Message message = new GenericMessage<String>("Hello World");
		PrintService ps = new PrintService();
		ps.print(message);
		
	}


}

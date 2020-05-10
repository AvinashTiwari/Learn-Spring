package learn.avinash.integration;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.support.MutableMessageBuilder;
import org.springframework.messaging.Message;


@SpringBootApplication
@Configuration
@ImportResource("integration-context.xml")
public class Application implements ApplicationRunner  {
	
	@Autowired
	private PrinterGateway gateway;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		List<Future<Message<String>>> futures = new ArrayList<Future<Message<String>>>();
		
		for(int x=0; x < 10; x++) {
			/*
			Message<String> message = MutableMessageBuilder.withPayload("Priniting Message for " + x)
					.setPriority(x).setHeader("MessageNumber", x).build();*/
			
			Message<String> message = MutableMessageBuilder.withPayload("Priniting Message for " + x)
					.setHeader("MessageNumber", x).build();
			
			System.out.println("Sending message");
			futures.add(this.gateway.print(message));
		}
		
		for(Future<Message<String>> future:futures) {
			System.out.println(future.get().getPayload());
		}
		
		
	}

}

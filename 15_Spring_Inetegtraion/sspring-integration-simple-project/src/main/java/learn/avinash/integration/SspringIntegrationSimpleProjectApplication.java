package learn.avinash.integration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.support.MessageBuilder;

@SpringBootApplication
@Configuration
@ImportResource("integration-context.xml")
public class SspringIntegrationSimpleProjectApplication implements ApplicationRunner {

	@Autowired
	private DirectChannel channel;
	
	public static void main(String[] args) {
		SpringApplication.run(SspringIntegrationSimpleProjectApplication.class, args);
	}
	
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		
		channel.subscribe(new MessageHandler() {

			@Override
			public void handleMessage(Message<?> message) throws MessagingException {
				new PrintService().print((Message<String>)message );;
				
			}});

		Message<String> message = MessageBuilder.withPayload("Hello world from builder pattern ")
				.setHeader("NewHeader", "New heder value").build();
		
		channel.send(message);
		
	}
	/*
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		
	

		Message<String> message = MessageBuilder.withPayload("Hello world from builder pattern ")
				.setHeader("NewHeader", "New heder value").build();
		
		PrintService ps = new PrintService();
		ps.print(message);
		
	}
*/
	
	/*
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		
		Map<String , Object> map = new HashMap<String, Object>();
		map.put("key", "value");
		MessageHeaders headers =  new MessageHeaders(map);
		Message message = new GenericMessage<String>("Hello World",headers);
		PrintService ps = new PrintService();
		ps.print(message);
		
	}*/


}

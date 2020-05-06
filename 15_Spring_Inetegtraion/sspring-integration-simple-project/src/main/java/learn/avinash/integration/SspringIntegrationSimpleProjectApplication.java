package learn.avinash.integration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.integration.support.MessageBuilder;

@SpringBootApplication
@Configuration
@ImportResource("integration-context.xml")
public class SspringIntegrationSimpleProjectApplication implements ApplicationRunner {

	@Autowired
	@Qualifier("inputChannel")
	private DirectChannel inputchannel;
	
	/*
	@Autowired
	@Qualifier("outputChannel")
	private DirectChannel outputchannel;
	*/

	
	public static void main(String[] args) {
		SpringApplication.run(SspringIntegrationSimpleProjectApplication.class, args);
	}
	
	
	
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
	
	
		Message<String> message = MessageBuilder.withPayload("Hello world from builder pattern ")
				.setHeader("NewHeader", "New heder value").build();
		
		inputchannel.send(message);
		
		MessagingTemplate template = new MessagingTemplate();
		Message message1 = template.sendAndReceive(inputchannel,message);
		System.out.println(message1);
		
	}
	
	/*
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
	
		outputchannel.subscribe(new MessageHandler() {

			@Override
			public void handleMessage(Message<?> message) throws MessagingException {
				System.out.print(message.getPayload());
				
			}});

		Message<String> message = MessageBuilder.withPayload("Hello world from builder pattern ")
				.setHeader("NewHeader", "New heder value").build();
		
		inputchannel.send(message);
		
		MessagingTemplate template = new MessagingTemplate();
		
	}*/
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

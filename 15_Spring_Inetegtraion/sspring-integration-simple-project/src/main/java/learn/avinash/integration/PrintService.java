package learn.avinash.integration;

import java.util.Map.Entry;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;

public class PrintService {
	
	public Message<String> print(Message<String> message) {
		MessageHeaders headers = message.getHeaders();
		
		for(Entry<String, Object> enter: headers.entrySet()) {
			System.out.println(enter.getKey());
			System.out.println(enter.getValue());			
		}
		
		System.out.println(message.getPayload());
		
		return MessageBuilder.withPayload("New Message").build();
	}

}

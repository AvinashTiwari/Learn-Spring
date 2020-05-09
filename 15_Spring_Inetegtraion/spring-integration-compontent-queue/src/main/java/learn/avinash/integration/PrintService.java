package learn.avinash.integration;

import java.util.Map.Entry;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;

public class PrintService {
	
	public Message<String> print(Message<String> message) {
		System.out.println(message.getPayload());
		int messagenumber = (int) message.getHeaders().get("messageNumber");
		return MessageBuilder.withPayload("Sending message " + messagenumber).build();
	}

}

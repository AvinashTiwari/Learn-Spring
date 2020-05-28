package learn.avinash.integration;

import java.util.Map.Entry;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;

public class PrintService {
	
	public void print(Message<?> message) {
		
		//throw new RuntimeException("This is error");
		System.out.println(message.getPayload() + " Normal");
		
	}

}

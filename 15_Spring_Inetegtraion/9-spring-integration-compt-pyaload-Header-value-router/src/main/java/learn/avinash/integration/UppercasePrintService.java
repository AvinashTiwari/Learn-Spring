package learn.avinash.integration;

import java.util.Map.Entry;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;

public class UppercasePrintService {
	
	public void print(Message<String> message) {
		System.out.println(message.getPayload().toUpperCase());
	}

}

package learn.avinash.integration;

import java.util.Map.Entry;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;

public class NumericPrintService {
	
	public void print(Message<String> message) {
		
		//throw new RuntimeException("This is error");
		System.out.println(message.getPayload() + " Numeric");
		
	}

}

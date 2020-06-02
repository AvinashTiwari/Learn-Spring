package learn.avinash.integration;

import org.springframework.messaging.Message;

public class CustomerTransformer {
	
	public String transform(Message<String> message) {
		String[] tokens = message.getPayload().split(" ");
		return tokens[1] + " , " + tokens[0];
		
	}

}

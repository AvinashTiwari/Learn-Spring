package learn.avinash.integration;

import java.util.Map.Entry;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;

public class UppercaseService {
	
	public String execute(Person person) {
		return (person.getFirstName() + "  " + person.getLastName()).toUpperCase();
	}
	

}

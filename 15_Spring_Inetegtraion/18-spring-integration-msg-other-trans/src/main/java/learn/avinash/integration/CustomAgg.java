package learn.avinash.integration;

import java.util.Map;

import org.springframework.integration.IntegrationMessageHeaderAccessor;
import org.springframework.integration.aggregator.AbstractAggregatingMessageGroupProcessor;
import org.springframework.integration.store.MessageGroup;
import org.springframework.messaging.Message;

public class CustomAgg extends AbstractAggregatingMessageGroupProcessor {

	@Override
	protected Object aggregatePayloads(MessageGroup group, Map<String, Object> defaultHeaders) {
		// TODO Auto-generated method stub
		StringBuilder builder = new StringBuilder();
		for(Message<?> msg:group.getMessages()) {
			System.out.print(msg.getHeaders().get(IntegrationMessageHeaderAccessor.CORRELATION_ID));
			builder.append(msg.getPayload());
		}
		return builder.toString();
	}

}

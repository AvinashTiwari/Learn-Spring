package learn.avinash.spring.state.machince.ssm.services;

import learn.avinash.spring.state.machince.ssm.domain.Payment;
import learn.avinash.spring.state.machince.ssm.domain.PaymentEvent;
import learn.avinash.spring.state.machince.ssm.domain.PaymentState;
import learn.avinash.spring.state.machince.ssm.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.Message;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.state.State;
import org.springframework.statemachine.support.StateMachineInterceptorAdapter;
import org.springframework.statemachine.transition.Transition;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class PaymentStateChangeListener extends StateMachineInterceptorAdapter<PaymentState, PaymentEvent> {
    private final PaymentRepository paymentRepository;

    @Override
    public void preStateChange(State<PaymentState, PaymentEvent> state, Message<PaymentEvent> message,
                               Transition<PaymentState, PaymentEvent> transition,
                               StateMachine<PaymentState, PaymentEvent> stateMachine) {
        Optional.ofNullable(message).ifPresent(msg->{
            Optional.ofNullable(Long.class.cast(msg.getHeaders().getOrDefault(PaymentServiceImpl.PAYMENT_ID_HEADER, -1L)))
            .ifPresent(payementId -> {
                Payment pyament = paymentRepository.getOne(payementId);
                pyament.setState(state.getId());
                paymentRepository.save(pyament);
            });
        });
    }
}

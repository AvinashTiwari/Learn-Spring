package learn.avinash.spring.state.machince.ssm.services;

import learn.avinash.spring.state.machince.ssm.domain.Payment;
import learn.avinash.spring.state.machince.ssm.domain.PaymentEvent;
import learn.avinash.spring.state.machince.ssm.domain.PaymentState;
import org.springframework.statemachine.StateMachine;

public interface PaymentService {
    Payment newPayment(Payment payment);
    StateMachine<PaymentState, PaymentEvent> preAuth(Long paymentId);
    StateMachine<PaymentState, PaymentEvent> authorizePayment(Long paymentId);
    StateMachine<PaymentState, PaymentEvent> declineAuth(Long paymentId);


}

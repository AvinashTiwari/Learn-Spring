package learn.avinash.spring.state.machince.ssm.services;

import learn.avinash.spring.state.machince.ssm.domain.Payment;
import learn.avinash.spring.state.machince.ssm.domain.PaymentEvent;
import learn.avinash.spring.state.machince.ssm.domain.PaymentState;
import learn.avinash.spring.state.machince.ssm.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.event.internal.DefaultAutoFlushEventListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.statemachine.support.DefaultStateMachineContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final StateMachineFactory<PaymentState, PaymentEvent> stateMachineFactory;
    private final PaymentStateChangeListener paymentStateChangeListener;
    public static final String  PAYMENT_ID_HEADER = "payment_id";
    @Override
    public Payment newPayment(Payment payment) {
        payment.setState(PaymentState.NEW);
        return paymentRepository.save(payment);
    }

    @Transactional
    @Override
    public StateMachine<PaymentState, PaymentEvent> preAuth(Long paymentId) {

        StateMachine<PaymentState, PaymentEvent> sm = build(paymentId);
        sendEvent(paymentId, sm, PaymentEvent.PRE_AUTH_APPROVED);
        return sm;
    }

    @Transactional
    @Override
    public StateMachine<PaymentState, PaymentEvent> authorizePayment(Long paymentId)
    {
        StateMachine<PaymentState, PaymentEvent> sm = build(paymentId);
        sendEvent(paymentId, sm, PaymentEvent.AUTH_APPROVED);

        return sm;
    }

    @Transactional
    @Override
    public StateMachine<PaymentState, PaymentEvent> declineAuth(Long paymentId) {
        StateMachine<PaymentState, PaymentEvent> sm = build(paymentId);
        sendEvent(paymentId, sm, PaymentEvent.AUTH_DECLINED);

        return sm;
    }

    private void sendEvent(Long paymentId,StateMachine<PaymentState, PaymentEvent> sm, PaymentEvent event){
        Message msg  = MessageBuilder.withPayload(event)
                .setHeader(PAYMENT_ID_HEADER, paymentId)
                .build();

        sm.sendEvent(msg);
    }

    private StateMachine<PaymentState, PaymentEvent> build(Long paymentId){
        Payment payment = paymentRepository.getOne(paymentId);
        StateMachine<PaymentState, PaymentEvent> sm = stateMachineFactory.getStateMachine(Long.toString(paymentId));

        sm.stop();
        sm.getStateMachineAccessor().doWithAllRegions(sma-> {
            sma.addStateMachineInterceptor(paymentStateChangeListener);
            sma.resetStateMachine(new DefaultStateMachineContext<>(payment.getState(), null,null,null));
        });
         sm.start();
        return sm;
    }
}

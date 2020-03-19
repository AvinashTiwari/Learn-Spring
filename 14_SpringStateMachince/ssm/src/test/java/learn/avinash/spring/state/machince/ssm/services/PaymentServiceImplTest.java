package learn.avinash.spring.state.machince.ssm.services;

import learn.avinash.spring.state.machince.ssm.domain.Payment;
import learn.avinash.spring.state.machince.ssm.repository.PaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PaymentServiceImplTest {

    @Autowired
    PaymentService paymentService;
    @Autowired
    PaymentRepository paymentRepository;
    Payment payment;
    @BeforeEach
    void setUp() {
        payment = Payment.builder().amount(new BigDecimal("12.99")).build();
    }

    @Transactional
    @Test
    void preAuth() {
        Payment savePayment = paymentService.newPayment(payment);
        paymentService.preAuth(savePayment.getI());
        Payment preAuthpayment = paymentRepository.getOne(savePayment.getI());
        System.out.println(preAuthpayment);

    }
}
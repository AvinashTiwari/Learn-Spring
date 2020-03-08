package learn.avinash.spring.state.machince.ssm.repository;

import learn.avinash.spring.state.machince.ssm.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}

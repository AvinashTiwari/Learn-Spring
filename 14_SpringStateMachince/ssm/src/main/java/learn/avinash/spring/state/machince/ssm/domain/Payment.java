package learn.avinash.spring.state.machince.ssm.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Payment {
    @Id
    @GeneratedValue
    private Long i;
    @Enumerated(EnumType.STRING)
    private PaymentState state;
    private BigDecimal amount;
}

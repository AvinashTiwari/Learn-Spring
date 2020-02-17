package learn.avinash.spring.springit.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.util.Objects;
@Entity
@Data
@NoArgsConstructor
public class Vote {
    @javax.persistence.Id
    @GeneratedValue
    private Long Id;
    private int vote;

   
}

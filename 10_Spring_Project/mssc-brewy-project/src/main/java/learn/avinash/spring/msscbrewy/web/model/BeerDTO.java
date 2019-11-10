package learn.avinash.spring.msscbrewy.web.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@Builder
public class BeerDTO {
    private UUID id;
    private String beerName;
    private String beerStyle;
    private Long upc;
}

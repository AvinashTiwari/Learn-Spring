package learn.avinash.spring.msscbrewy.services;

import learn.avinash.spring.msscbrewy.web.model.BeerDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDTO getBeerById(UUID beerId) {
        return BeerDTO.builder().id(UUID.randomUUID())
                .beerName("GC")
                .beerStyle("PA")
                .build();
    }
}

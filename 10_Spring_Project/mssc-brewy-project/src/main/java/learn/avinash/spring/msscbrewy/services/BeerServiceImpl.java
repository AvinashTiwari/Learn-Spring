package learn.avinash.spring.msscbrewy.services;

import learn.avinash.spring.msscbrewy.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder().id(UUID.randomUUID())
                .beerName("GC")
                .beerStyle("PA")
                .build();
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDTO) {
        return BeerDto.builder().id(UUID.randomUUID())
                .beerName(beerDTO.getBeerName())
                .beerStyle(beerDTO.getBeerStyle())
                .build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDto beerDTO) {


    }

    @Override
    public void deleteById(UUID beerId) {
     log.debug("Deleting Beer..");
    }
}

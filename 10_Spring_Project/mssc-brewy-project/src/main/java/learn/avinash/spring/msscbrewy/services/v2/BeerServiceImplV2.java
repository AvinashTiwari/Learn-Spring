package learn.avinash.spring.msscbrewy.services.v2;

import learn.avinash.spring.msscbrewy.web.model.BeerDTO;
import learn.avinash.spring.msscbrewy.web.model.v2.BeerDtoV2;
import learn.avinash.spring.msscbrewy.web.model.v2.BeerStyleEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImplV2 implements BeerServiceV2 {
    @Override
    public BeerDtoV2 getBeerById(UUID beerId) {
        return BeerDtoV2.builder().id(UUID.randomUUID())
                .beerName("GC")
                .beerStyle(BeerStyleEnum.ALE)
                .build();
    }

    @Override
    public BeerDtoV2 saveNewBeer(BeerDtoV2 beerDTO) {
        return BeerDtoV2.builder().id(UUID.randomUUID())
                .beerName(beerDTO.getBeerName())
                .beerStyle(BeerStyleEnum.ALE)
                .build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDtoV2 beerDTO) {


    }

    @Override
    public void deleteById(UUID beerId) {
     log.debug("Deleting Beer..");
    }
}

package learn.avinash.spring.msscbrewy.services.v2;

import learn.avinash.spring.msscbrewy.services.BeerService;
import learn.avinash.spring.msscbrewy.web.model.BeerDTO;
import learn.avinash.spring.msscbrewy.web.model.v2.BeerDTOV2;
import learn.avinash.spring.msscbrewy.web.model.v2.BeerStyleEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImplV2 implements BeerServiceV2 {
    @Override
    public BeerDTOV2 getBeerById(UUID beerId) {
        return BeerDTOV2.builder().id(UUID.randomUUID())
                .beerName("GC")
                .beerStyle(BeerStyleEnum.ALE)
                .build();
    }

    @Override
    public BeerDTOV2 saveNewBeer(BeerDTOV2 beerDTO) {
        return BeerDTOV2.builder().id(UUID.randomUUID())
                .beerName(beerDTO.getBeerName())
                .beerStyle(BeerStyleEnum.ALE)
                .build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDTOV2 beerDTO) {


    }

    @Override
    public void deleteById(UUID beerId) {
     log.debug("Deleting Beer..");
    }
}

package learn.avinash.spring.msscbrewy.services.v2;


import learn.avinash.spring.msscbrewy.web.model.v2.BeerDtoV2;

import java.util.UUID;

public interface BeerServiceV2 {

    BeerDtoV2 getBeerById(UUID beerId);

    BeerDtoV2 saveNewBeer(BeerDtoV2 beerDTO);

    void updateBeer(UUID beerId, BeerDtoV2 beerDTO);

    void deleteById(UUID beerId);
}

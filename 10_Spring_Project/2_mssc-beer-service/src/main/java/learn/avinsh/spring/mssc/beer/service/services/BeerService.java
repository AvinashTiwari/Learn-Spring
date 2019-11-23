package learn.avinsh.spring.mssc.beer.service.services;


import learn.avinsh.spring.mssc.beer.service.web.model.BeerDto;
import learn.avinsh.spring.mssc.beer.service.web.model.BeerPagedList;
import learn.avinsh.spring.mssc.beer.service.web.model.BeerStyleEnum;
import org.springframework.data.domain.PageRequest;

import java.util.UUID;


public interface BeerService {
    BeerPagedList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest, Boolean showInventoryOnHand);

    BeerDto getById(UUID beerId, Boolean showInventoryOnHand);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto);

    BeerDto getByUpc(String upc);
}
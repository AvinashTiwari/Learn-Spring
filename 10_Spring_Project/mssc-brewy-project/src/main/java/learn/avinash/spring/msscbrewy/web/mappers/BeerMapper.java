package learn.avinash.spring.msscbrewy.web.mappers;

import learn.avinash.spring.msscbrewy.domain.Beer;
import learn.avinash.spring.msscbrewy.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto dto);
}
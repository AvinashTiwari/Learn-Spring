package learn.avinash.spring.springdoc.web.mappers;


import learn.avinash.spring.springdoc.domain.Beer;
import learn.avinash.spring.springdoc.web.model.BeerDto;
import org.mapstruct.Mapper;

/**
 * Created by jt on 2019-05-25.
 */
@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDto BeerToBeerDto(Beer beer);

    Beer BeerDtoToBeer(BeerDto dto);
}

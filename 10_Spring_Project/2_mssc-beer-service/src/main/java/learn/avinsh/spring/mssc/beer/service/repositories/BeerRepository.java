package learn.avinsh.spring.mssc.beer.service.repositories;


import learn.avinsh.spring.mssc.beer.service.domain.Beer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {
}
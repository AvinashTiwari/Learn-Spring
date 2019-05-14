package learn.avinash.spring.rollingstoneecommerceproductapi.dao;

import learn.avinash.spring.rollingstoneecommerceproductapi.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProductDaoRepository extends PagingAndSortingRepository {
    List<Product> findAll();
}

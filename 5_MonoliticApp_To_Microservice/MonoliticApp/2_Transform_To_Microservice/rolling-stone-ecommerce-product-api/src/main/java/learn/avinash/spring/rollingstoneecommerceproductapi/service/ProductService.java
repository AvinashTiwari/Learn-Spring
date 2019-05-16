package learn.avinash.spring.rollingstoneecommerceproductapi.service;




import learn.avinash.spring.rollingstoneecommerceproductapi.model.Product;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ProductService {

   Product save(Product product);
   Optional<Product> get(long id);
   Page<Product> getProductsByPage(Integer pageNumber, Integer pageSize);
   void update(long id, Product product);
   void delete(long id);
}

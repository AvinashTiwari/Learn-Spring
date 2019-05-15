package learn.avinash.spring.rollingstoneecommerceproductapi.service;




import learn.avinash.spring.rollingstoneecommerceproductapi.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

   Product save(Product product);
   Optional<Product> get(long id);
   List<Product> list();
   void update(long id, Product category);
   void delete(long id);
}

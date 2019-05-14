package learn.avinash.spring.rollingstoneecommerceproductapi.service;




import learn.avinash.spring.rollingstoneecommerceproductapi.model.Product;

import java.util.List;

public interface ProductService {

   long save(Product product);
   Product get(long id);
   List<Product> list();
   void update(long id, Product category);
   void delete(long id);
}

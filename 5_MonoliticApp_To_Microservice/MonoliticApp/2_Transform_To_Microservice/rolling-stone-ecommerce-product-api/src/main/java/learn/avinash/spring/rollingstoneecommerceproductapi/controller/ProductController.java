package learn.avinash.spring.rollingstoneecommerceproductapi.controller;

import learn.avinash.spring.rollingstoneecommerceproductapi.model.Product;
import learn.avinash.spring.rollingstoneecommerceproductapi.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

   @Autowired
   private ProductServiceImpl productService;

   /*---Add new Product---*/
   @PostMapping("/product")
   public ResponseEntity<?> save(@RequestBody Product product) {
      Product saveProduct = productService.save(product);
      return ResponseEntity.ok().body("New Product has been saved with ID:" + saveProduct.getId());
   }

   /*---Get a Product by id---*/
   @GetMapping("/product/{id}")
   public ResponseEntity<Product> get(@PathVariable("id") long id) {
      Optional<Product> product = productService.get(id);
      return ResponseEntity.ok().body(product.get());
   }

   /*---get all Product---*/
   @GetMapping("/product")
   public @ResponseBody Page<Product> list(
           @RequestParam(value="pageNum",required = true , defaultValue = "0")
           Integer pageNum,
           @RequestParam(value="pageSize",required = true , defaultValue = "0")
                   Integer pageSize) {
      Page<Product> product = productService.getProductsByPage(pageNum, pageSize);
      return product;
   }

   /*---Update a Product by id---*/
   @PutMapping("/product/{id}")
   public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Product product) {
      productService.update(id, product);
      return ResponseEntity.ok().body("Product has been updated successfully.");
   }

   /*---Delete a Product by id---*/
   @DeleteMapping("/product/{id}")
   public ResponseEntity<?> delete(@PathVariable("id") long id) {
      productService.delete(id);
      return ResponseEntity.ok().body("Product has been deleted successfully.");
   }
}
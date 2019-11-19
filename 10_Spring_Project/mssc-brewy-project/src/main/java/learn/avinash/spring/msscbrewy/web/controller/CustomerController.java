package learn.avinash.spring.msscbrewy.web.controller;

import learn.avinash.spring.msscbrewy.services.CustomerService;

import learn.avinash.spring.msscbrewy.web.model.CustomerDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {

     private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable("customerId") UUID customerId){

        return  new ResponseEntity<>(customerService.getCustomerbyId(customerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handlePost(CustomerDTO customerDTO){
        CustomerDTO saveDto = customerService.saveNewCustomer(customerDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","http://localhost:8080/api/v1/customer/"+ saveDto.getId().toString());
        return  new ResponseEntity(headers, HttpStatus.CREATED);

    }

    @PutMapping("/{beerId}")
    public ResponseEntity handleUpdate(@PathVariable UUID beerId,CustomerDTO customerDTO){
        customerService.updateCustomer(beerId,customerDTO);
        return  new ResponseEntity( HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(UUID customerId){

        customerService.deleteById(customerId);
    }
}

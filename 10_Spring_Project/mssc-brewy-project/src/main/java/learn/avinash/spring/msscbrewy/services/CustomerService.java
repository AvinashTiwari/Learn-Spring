package learn.avinash.spring.msscbrewy.services;

import learn.avinash.spring.msscbrewy.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getCustomerById(UUID customerId);

    CustomerDto saveNewCustomer(CustomerDto customerDTO);

    void updateCustomer(UUID beerId, CustomerDto customerDTO);

    void deleteById(UUID customerId);
}

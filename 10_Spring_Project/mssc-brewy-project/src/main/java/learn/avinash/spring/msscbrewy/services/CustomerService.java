package learn.avinash.spring.msscbrewy.services;

import learn.avinash.spring.msscbrewy.web.model.CustomerDTO;

import java.util.UUID;

public interface CustomerService {
    CustomerDTO getCustomerbyId(UUID customerId);
}

package learn.avinash.spring.msscbrewy.services;

import learn.avinash.spring.msscbrewy.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder().id(UUID.randomUUID())
                .name("Avinash")
                .build();
    }

    @Override
    public CustomerDto saveNewCustomer(CustomerDto customerDTO) {
        return CustomerDto.builder().id(UUID.randomUUID())
                .name("Avinash")
                .build();
    }

    @Override
    public void updateCustomer(UUID beerId, CustomerDto customerDTO) {

    }

    @Override
    public void deleteById(UUID customerId) {
        log.debug("Deleting Beer..");

    }
}

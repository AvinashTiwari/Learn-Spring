package learn.avinash.spring.msscbrewy.services;

import learn.avinash.spring.msscbrewy.web.model.BeerDTO;
import learn.avinash.spring.msscbrewy.web.model.CustomerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDTO getCustomerbyId(UUID customerId) {
        return CustomerDTO.builder().id(UUID.randomUUID())
                .name("Avinash")
                .build();
    }

    @Override
    public CustomerDTO saveNewCustomer(CustomerDTO customerDTO) {
        return CustomerDTO.builder().id(UUID.randomUUID())
                .name("Avinash")
                .build();
    }

    @Override
    public void updateCustomer(UUID beerId, CustomerDTO customerDTO) {

    }

    @Override
    public void deleteById(UUID customerId) {
        log.debug("Deleting Beer..");

    }
}

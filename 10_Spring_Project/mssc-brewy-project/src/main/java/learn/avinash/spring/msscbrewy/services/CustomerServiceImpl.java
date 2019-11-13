package learn.avinash.spring.msscbrewy.services;

import learn.avinash.spring.msscbrewy.web.model.BeerDTO;
import learn.avinash.spring.msscbrewy.web.model.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDTO getCustomerbyId(UUID customerId) {
        return CustomerDTO.builder().id(UUID.randomUUID())
                .name("Avinash")
                .build();
    }
}

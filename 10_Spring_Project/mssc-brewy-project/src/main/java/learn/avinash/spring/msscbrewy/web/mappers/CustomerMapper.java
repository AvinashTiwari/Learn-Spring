package learn.avinash.spring.msscbrewy.web.mappers;

import learn.avinash.spring.msscbrewy.domain.Customer;
import learn.avinash.spring.msscbrewy.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    Customer customerDtoToCustomer(CustomerDto dto);

    CustomerDto customerToCustomerDto(Customer customer);
}
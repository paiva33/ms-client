package br.com.brasilprev.application.customer.adapter.in.web.mapper;

import br.com.brasilprev.application.customer.adapter.in.web.payload.CustomerResponse;
import br.com.brasilprev.application.customer.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerResponseMapper {

    @Mapping(source = "name", target = "name")
    Customer toDomain(CustomerResponse customerResponse);

    @Mapping(source = "name", target = "name")
    CustomerResponse toPayload(Customer customer);

    List<CustomerResponse> toPayload(List<Customer> customers);


}

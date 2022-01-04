package br.com.brasilprev.application.customer.adapter.in.web.mapper;

import br.com.brasilprev.application.customer.adapter.in.web.payload.CustomerRequest;
import br.com.brasilprev.application.customer.core.builders.CustomerBuilder;
import br.com.brasilprev.application.customer.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerRequestMapper {

    @Mapping(source = "name", target = "name")
    @Mapping(source = "document", target = "document")
    Customer toDomain(CustomerRequest request);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "document", target = "document")
    CustomerRequest toPayload(Customer customer);

    List<Customer> toDomain(List<CustomerRequest> source);
    List<CustomerRequest> toPayLoad(List<CustomerRequest> requests);

    default Customer fromId(Long id) {
        if (id == null) {
            return null;
        }
        return CustomerBuilder.builder()
                .id(id)
                .build();
    }

}

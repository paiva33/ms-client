package br.com.brasilprev.application.customer.adapter.in.web.mapper;

import br.com.brasilprev.application.customer.adapter.in.web.builder.AddressResponseBuilder;
import br.com.brasilprev.application.customer.adapter.in.web.builder.CustomerResponseBuilder;
import br.com.brasilprev.application.customer.adapter.in.web.payload.CustomerResponse;
import br.com.brasilprev.application.customer.core.domain.Customer;
import br.com.brasilprev.application.utility.converter.DozerConverter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerResponseMapper {

    public CustomerResponse mapDomainToRequest(Customer customer) {
        return CustomerResponseBuilder.builder()
                .document(customer.getDocument())
                .name(customer.getName())
                .address(Optional.of(customer.getAddress())
                                        .map(address ->
                                                    AddressResponseBuilder.builder()
                                                            .number(address.getNumber())
                                                            .city(address.getCity())
                                                            .country(address.getCountry())
                                                            .state(address.getState())
                                .build()).orElseThrow())
                .build();
    }

    public List<CustomerResponse> mapDomainToRequestList(List<Customer> customers) {
        return DozerConverter.parseListObjects(customers, CustomerResponse.class);
    }
}

package br.com.brasilprev.application.customer.adapter.in.web.mappers;

import br.com.brasilprev.application.customer.adapter.in.web.payload.CustomerResponse;
import br.com.brasilprev.application.customer.core.domain.Customer;
import br.com.brasilprev.application.utility.converter.DozerConverter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerResponseMapper {

    public CustomerResponse mapDomainToRequest(Customer customer) {
        return CustomerResponse.builder()
                .document(customer.getDocument())
                .name(customer.getName())
                .build();
    }

    public List<CustomerResponse> mapDomainToRequestList(List<Customer> customers) {
        return DozerConverter.parseListObjects(customers, CustomerResponse.class);
    }
}

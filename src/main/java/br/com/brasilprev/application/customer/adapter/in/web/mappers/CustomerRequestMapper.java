package br.com.brasilprev.application.customer.adapter.in.web.mappers;

import br.com.brasilprev.application.customer.adapter.in.web.payload.CustomerRequest;
import br.com.brasilprev.application.customer.core.domain.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerRequestMapper {

    public Customer mapRequesToDomainWithId(Long id) {
        return Customer.builder()
                .id(id)
                .build();
    }

    public Customer mapRequestToDomain(CustomerRequest request) {
        return Customer.builder()
                .document(request.getDocument())
                .name(request.getName())
                .build();
    }

    public Customer mapRequestToDomainWithDocument(String document) {
        return Customer.builder()
                .document(document)
                .build();
    }
}

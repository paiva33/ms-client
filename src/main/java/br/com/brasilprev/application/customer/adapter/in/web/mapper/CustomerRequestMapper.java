package br.com.brasilprev.application.customer.adapter.in.web.mapper;

import br.com.brasilprev.application.customer.adapter.in.web.payload.CustomerRequest;
import br.com.brasilprev.application.customer.core.domain.Customer;
import br.com.brasilprev.application.utility.converter.DozerConverter;
import org.springframework.stereotype.Component;

@Component
public class CustomerRequestMapper {

    public Customer mapRequesToDomainWithId(Long id) {
        return new Customer(id);
    }

    public Customer mapRequestToDomain(CustomerRequest request) {
        return DozerConverter.parseObject(request, Customer.class);
    }

    public Customer mapRequestToDomainWithDocument(String document) {
        return new Customer(document);
    }
}

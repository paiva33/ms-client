package br.com.brasilprev.application.customer.adapter.in.web;

import br.com.brasilprev.application.customer.core.domain.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerResponseMapper {

    public CustomerResponse mapDomainToRequest(Customer customer) {
        return CustomerResponse.builder()
                .cpf(customer.getCpf())
                .name(customer.getName())
                .build();
    }
}

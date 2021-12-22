package br.com.brasilprev.application.customer.adapter.in.web;

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
                .cpf(request.getCpf())
                .name(request.getName())
                .build();
    }

    public Customer mapRequestToDomainWithCpf(String cpf) {
        return Customer.builder()
                .cpf(cpf)
                .build();
    }
}

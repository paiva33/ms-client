package br.com.brasilprev.customer.adapter.in.web;

import br.com.brasilprev.customer.application.domain.Customer;

public class CustomerRequestMapper {

    public Customer mapRequestToDomain(CustomerRequest request) {
        return Customer.builder()
                .cpf(request.getCpf())
                .name(request.getName())
                .build();
    }
}

package br.com.brasilprev.customer.adapter.in.web;

import br.com.brasilprev.customer.application.domain.Customer;

public class CustomerResponseMapper {

    public CustomerResponse mapDomainToRequest(Customer customer) {
        return CustomerResponse.builder()
                .cpf(customer.getCpf())
                .name(customer.getName())
                .build();
    }
}

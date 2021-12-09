package br.com.brasilprev.customer.adapter.out.persistence;

import br.com.brasilprev.customer.application.domain.Customer;

import java.util.Optional;

/**
 * Customer Mapper
 */
class CustomerMapper {

    public CustomerEntity mapToJpaEntity(Customer customer) {
        return CustomerEntityBuilder.builder()
                .id(customer.getId())
                .cpf(customer.getCpf())
                .name(customer.getName())
                .build();
    }

    public Optional<Customer> mapToDomainEntity(CustomerEntity customerEntity) {
        return Optional.of(Customer.builder()
                .id(customerEntity.getId())
                .cpf(customerEntity.getCpf())
                .name(customerEntity.getName())
                .build());
    }
}

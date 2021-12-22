package br.com.brasilprev.application.customer.adapter.out.persistence;

import br.com.brasilprev.application.customer.core.domain.Customer;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Customer Mapper
 */
@Component
class CustomerMapper {

    public CustomerEntity mapToJpaEntity(Customer customer) {
        return CustomerEntityBuilder.builder()
                .id(customer.getId())
                .cpf(customer.getCpf())
                .name(customer.getName())
                .address(AddressEntityBuilder.builder()
                        .street(customer.getAddress().getStreet())
                        .number(customer.getAddress().getNumber())
                        .district(customer.getAddress().getDistrict())
                        .state(customer.getAddress().getState())
                        .build())
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

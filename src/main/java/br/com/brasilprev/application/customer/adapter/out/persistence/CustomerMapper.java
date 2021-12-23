package br.com.brasilprev.application.customer.adapter.out.persistence;

import br.com.brasilprev.application.customer.core.domain.Customer;
import br.com.brasilprev.application.utility.converter.DozerConverter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Customer Mapper
 */
@Component
class CustomerMapper {

    public CustomerEntity mapToJpaEntity(Customer customer) {
        return CustomerEntityBuilder.builder()
                .id(customer.getId())
                .document(customer.getDocument())
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
        return Optional.ofNullable(Customer.builder()
                .id(customerEntity.getId())
                .document(customerEntity.getDocument())
                .name(customerEntity.getName())
                .build());
    }

    public List<Customer> mapToListDomainEntity(List<CustomerEntity> entities) {
        return DozerConverter
                .parseListObjects(entities, Customer.class);
    }
}

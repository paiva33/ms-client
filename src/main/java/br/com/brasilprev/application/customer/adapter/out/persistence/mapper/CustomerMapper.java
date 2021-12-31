package br.com.brasilprev.application.customer.adapter.out.persistence.mapper;

import br.com.brasilprev.application.customer.adapter.out.persistence.builders.AddressEntityBuilder;
import br.com.brasilprev.application.customer.adapter.out.persistence.builders.CustomerEntityBuilder;
import br.com.brasilprev.application.customer.adapter.out.persistence.entity.CustomerEntity;
import br.com.brasilprev.application.customer.core.builders.CustomerBuilder;
import br.com.brasilprev.application.customer.core.domain.Customer;
import br.com.brasilprev.application.utility.converter.DozerConverter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Customer Mapper
 */
@Component
public class CustomerMapper {

    public CustomerEntity mapToJpaEntity(Customer customer) {
        return CustomerEntityBuilder.builder()
                .id(customer.getId())
                .document(customer.getDocument())
                .name(customer.getName())
                .address(AddressEntityBuilder.builder()
                        .street(customer.getAddress().getStreet())
                        .number(customer.getAddress().getNumber())
                        .district(customer.getAddress().getCountry())
                        .state(customer.getAddress().getState())
                        .build())
                .build();
    }

    public Optional<Customer> mapToDomainEntity(CustomerEntity customerEntity) {
        return Optional.ofNullable(CustomerBuilder.builder()
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

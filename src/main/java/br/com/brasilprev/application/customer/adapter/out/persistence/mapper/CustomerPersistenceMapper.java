package br.com.brasilprev.application.customer.adapter.out.persistence.mapper;

import br.com.brasilprev.application.customer.adapter.out.persistence.entity.CustomerEntity;
import br.com.brasilprev.application.customer.core.domain.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerPersistenceMapper {

    CustomerEntity toEntity(Customer customer);
    Customer toDomain(CustomerEntity entity);
    List<CustomerEntity> toEntity(List<Customer> customers);
    List<Customer> toDomain(List<CustomerEntity> entities);
}

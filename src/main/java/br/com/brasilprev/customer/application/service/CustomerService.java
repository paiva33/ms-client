package br.com.brasilprev.customer.application.service;

import br.com.brasilprev.customer.application.domain.Customer;
import br.com.brasilprev.customer.application.port.in.CustomerUseCase;
import br.com.brasilprev.customer.application.port.out.CrudCustomerPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 *
 */
@Service
@RequiredArgsConstructor
public class CustomerService implements CustomerUseCase {

    private final CrudCustomerPort crudCustomerPort;

    @Override
    public Optional<Customer> create(Customer customer) {
        return crudCustomerPort.save(customer);
    }

    @Override
    public Optional<Customer> read(Customer customer) {
        return Optional.empty();
    }

    @Override
    public Optional<Customer> update(Customer customer) {
        return crudCustomerPort.update(customer);
    }

    @Override
    public Optional<Void> delete(Customer customer) {
        return crudCustomerPort.delete(customer);
    }

}

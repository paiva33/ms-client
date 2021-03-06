package br.com.brasilprev.application.customer.core.service;

import br.com.brasilprev.application.customer.core.domain.Customer;
import br.com.brasilprev.application.customer.core.exceptions.CustomerNotFoundException;
import br.com.brasilprev.application.customer.core.port.in.CustomerUseCase;
import br.com.brasilprev.application.customer.core.port.out.CrudCustomerPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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
        return crudCustomerPort.read(customer);
    }

    @Override
    public List<Customer> readAll() { return crudCustomerPort.readAll(); }

    @Override
    public Optional<Customer> update(Customer customer) {
        return crudCustomerPort.update(customer);
    }

    @Override
    public void delete(Customer customer) throws CustomerNotFoundException {
        if (crudCustomerPort.read(customer).isPresent())
                throw new CustomerNotFoundException();
        crudCustomerPort.delete(customer);
    }

}

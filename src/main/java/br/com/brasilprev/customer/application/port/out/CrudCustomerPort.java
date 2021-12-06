package br.com.brasilprev.customer.application.port.out;

import br.com.brasilprev.customer.application.domain.Customer;

import java.util.Optional;

public interface CrudCustomerPort {

    Optional<Customer> save(Customer customer);
    Optional<Customer> read(Customer customer);
    Optional<Customer> update(Customer customer);
    void delete(Customer Customer);
}

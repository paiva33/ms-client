package br.com.brasilprev.application.customer.core.port.out;

import br.com.brasilprev.application.customer.core.domain.Customer;

import java.util.List;
import java.util.Optional;

public interface CrudCustomerPort {

    Optional<Customer> save(Customer customer);
    Optional<Customer> read(Customer customer);
    Optional<Customer> update(Customer customer);
    Optional<Void> delete(Customer Customer);
    List<Customer> readAll();
}

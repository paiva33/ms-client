package br.com.brasilprev.customer.application.port.in;

import br.com.brasilprev.customer.application.domain.Customer;

import java.util.Optional;

public interface CustomerUseCase {
	
	Optional<Customer> create(Customer customer);
	Optional<Customer> read(Customer customer);
	Optional<Customer> update(Customer customer);
	void delete(Customer customer);


}

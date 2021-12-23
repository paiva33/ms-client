package br.com.brasilprev.application.customer.core.port.in;

import br.com.brasilprev.application.customer.core.domain.Customer;

import java.util.List;
import java.util.Optional;

/**
 * Customer Use Case
 */
public interface CustomerUseCase {

	/**
	 *
	 * @param customer
	 * @return
	 */
	Optional<Customer> create(Customer customer);

	/**
	 *
	 * @param customer
	 * @return
	 */
	Optional<Customer> read(Customer customer);

	/**
	 *
	 * @return
	 */
	List<Customer> readAll();

	/**
	 *
	 * @param customer
	 * @return
	 */
	Optional<Customer> update(Customer customer);

	/**
	 *
	 * @param customer
	 */
	Optional<Void> delete(Customer customer);


}

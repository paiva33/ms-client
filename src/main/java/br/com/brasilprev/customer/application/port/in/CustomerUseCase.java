package br.com.brasilprev.customer.application.port.in;

import br.com.brasilprev.customer.application.domain.Customer;

import java.util.Optional;

/**
 *
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
	 * @param customer
	 * @return
	 */
	Optional<Customer> update(Customer customer);

	/**
	 *
	 * @param customer
	 */
	void delete(Customer customer);


}

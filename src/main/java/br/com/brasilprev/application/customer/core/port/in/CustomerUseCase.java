package br.com.brasilprev.application.customer.core.port.in;

import br.com.brasilprev.application.customer.core.domain.Customer;
import br.com.brasilprev.application.customer.core.exceptions.CustomerNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
	 * @param customer
	 * @return
	 */
	Page<Customer> search(Customer customer, Pageable pageable);

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
	void delete(Customer customer) throws CustomerNotFoundException;


}

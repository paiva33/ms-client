package br.com.brasilprev.customer.application.port.in;

import br.com.brasilprev.customer.application.domain.Customer;

public interface CustomerUseCase {
	
	public Customer create(Customer customer);
	public Customer loadCustomerById(Long id);

}

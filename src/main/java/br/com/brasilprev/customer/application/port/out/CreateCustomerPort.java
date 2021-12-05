package br.com.brasilprev.customer.application.port.out;

import br.com.brasilprev.customer.application.domain.Customer;

public interface CreateCustomerPort {

	Customer saveCustomer(Customer customer);

}

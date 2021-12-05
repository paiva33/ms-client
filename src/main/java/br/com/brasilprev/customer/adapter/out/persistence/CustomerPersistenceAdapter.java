package br.com.brasilprev.customer.adapter.out.persistence;

import br.com.brasilprev.customer.application.port.out.LoadCustomerPort;
import br.com.brasilprev.customer.application.port.out.SearchCustomerPort;

public class CustomerPersistenceAdapter implements LoadCustomerPort, SearchCustomerPort {
	
	private CustomerRepository customerRepository;
	private CustomerMapper customerMapper;

}

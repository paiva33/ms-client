package br.com.brasilprev.customer.application.service;

import org.springframework.stereotype.Service;

import br.com.brasilprev.customer.application.domain.Customer;
import br.com.brasilprev.customer.application.port.in.CustomerUseCase;
import br.com.brasilprev.customer.application.port.out.CreateCustomerPort;
import br.com.brasilprev.customer.application.port.out.LoadCustomerPort;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class CustomerService implements CustomerUseCase {
	
	private final LoadCustomerPort loadCustomerPort;
	private final CreateCustomerPort createCustomerPort;

	@Override
	public Customer create(Customer customer) {
		return createCustomerPort.saveCustomer(customer);
	}

	@Override
	public Customer loadCustomerById(Long id) {
		return loadCustomerPort.loadById(id);
	}
	
}

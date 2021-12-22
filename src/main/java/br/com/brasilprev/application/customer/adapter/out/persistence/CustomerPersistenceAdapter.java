package br.com.brasilprev.application.customer.adapter.out.persistence;

import br.com.brasilprev.application.customer.core.domain.Customer;
import br.com.brasilprev.application.customer.core.port.out.CrudCustomerPort;
import br.com.brasilprev.application.customer.core.port.out.SearchCustomerPort;
import br.com.brasilprev.application.utility.annotations.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

/**
 * Customer Adapter
 */
@RequiredArgsConstructor
@PersistenceAdapter
public class CustomerPersistenceAdapter implements CrudCustomerPort, SearchCustomerPort {
	
	private final CustomerRepository customerRepository;
	private final CustomerMapper customerMapper;

	@Override
	public Optional<Customer> save(Customer customer) {
		return customerMapper
				.mapToDomainEntity(customerRepository
						.save(customerMapper
								.mapToJpaEntity(customer)));
	}

	@Override
	public Optional<Customer> read(Customer customer) {
		return customerRepository.findByCpf(customer.getCpf())
				.flatMap(c -> customerMapper.mapToDomainEntity(c));
	}

	@Override
	public Optional<Customer> update(Customer customer) {
		return customerMapper
				.mapToDomainEntity(customerRepository
						.save(customerMapper.mapToJpaEntity(customer)));
	}

	@Override
	public Optional<Void> delete(Customer customer) {
		return customerRepository.findByCpf(customer.getCpf())
				.flatMap(customerEntity -> {
					customerRepository.delete(customerEntity);
					return Optional.empty();
				});
	}
}

package br.com.brasilprev.application.customer.adapter.out.persistence;

import java.util.List;
import java.util.Optional;

import br.com.brasilprev.application.customer.adapter.out.persistence.mapper.CustomerPersistenceMapper;
import br.com.brasilprev.application.customer.core.domain.Customer;
import br.com.brasilprev.application.customer.core.port.out.CrudCustomerPort;
import br.com.brasilprev.application.customer.core.port.out.SearchCustomerPort;
import br.com.brasilprev.application.utility.annotations.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

/**
 * Customer Adapter
 */
@RequiredArgsConstructor
@PersistenceAdapter
public class CustomerPersistenceAdapter implements CrudCustomerPort, SearchCustomerPort {
	
	private final CustomerRepository customerRepository;
	private final CustomerPersistenceMapper customerPersistenceMapper;

	@Override
	public Optional<Customer> save(Customer customer) {
		return Optional
				.of(customerPersistenceMapper
					.toDomain(customerRepository
						.save(customerPersistenceMapper
								.toEntity(customer))));
	}

	@Override
	public Optional<Customer> read(Customer customer) {
		return customerRepository.findById(customer.getId())
				.map(c -> customerPersistenceMapper.toDomain(c));
	}

	@Override
	public Optional<Customer> update(Customer customer) {
		return Optional
				.of(customerPersistenceMapper
					.toDomain(customerRepository
						.save(customerPersistenceMapper.toEntity(customer))));
	}

	@Override
	public Optional<Void> delete(Customer customer) {
		customerRepository
				.delete(customerPersistenceMapper.toEntity(customer));
		return Optional.empty();
	}

	@Override
	public List<Customer> readAll() {
		return Optional.ofNullable(customerRepository.findAll())
				.map(customerEntities -> customerPersistenceMapper.toDomain(customerEntities))
				.orElseGet(null);
	}
}

package br.com.brasilprev.application.customer.adapter.out.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Customer Repository
 */
@Repository
interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {

    Optional<CustomerEntity> findByCpf(String cpf);
}

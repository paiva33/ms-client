package br.com.brasilprev.application.customer.adapter.out.persistence;

import br.com.brasilprev.application.customer.adapter.out.persistence.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Customer Repository
 */
@Repository
interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    Optional<CustomerEntity> findByDocument(String document);
}

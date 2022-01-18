package br.com.brasilprev.application.customer.core;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import br.com.brasilprev.application.customer.core.builders.CustomerBuilder;
import br.com.brasilprev.application.customer.core.domain.Customer;
import br.com.brasilprev.application.customer.core.port.out.CrudCustomerPort;
import br.com.brasilprev.application.customer.core.service.CustomerService;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.WARN)
public class CustomerServiceTest {

    @Mock
    private CrudCustomerPort crudCustomerPort;

    @InjectMocks
    private CustomerService customerUseCase;
    
    @Test
    void testCreateCustomer() {
    	
    	log.info("create customer");
        Customer customer = getCustomer();
        Customer newCustomer = getCustomer();
        newCustomer.setId(1L);

        when(crudCustomerPort.save(customer)).thenReturn(Optional.of(newCustomer));

        var result = customerUseCase.create(customer);

        assertThat(result, notNullValue());

    }
    
    @Test
    void testReadCustomer() {
    	
    	log.info("read customer");
        Customer customer1 = getCustomer();
        customer1.setDocument("111111111");

        Customer customer2 = getCustomer();
        customer2.setId(1L);
        customer2.setDocument("111111111");
        customer2.setName("Joao ");

        var result = customerUseCase.read(customer1);

        assertThat(customer2.getDocument(), equalTo("111111111"));
        assertThat(customer2.getName(), equalTo("Joao "));
        assertThat(customer2.getId(), equalTo(1L));
        assertThat(result, notNullValue());
    }


    @Test
    void testUpdateCustomer() {
    	
    	log.info("update customer");
        Customer customer1 = getCustomer();
        customer1.setId(1L);
        customer1.setName("Fulano 2");

        Customer domain2 = getCustomer();
        domain2.setId(1L);
        domain2.setName("Fulano 3");

        when(crudCustomerPort.update(customer1)).thenReturn(Optional.of(domain2));

        var result =  customerUseCase.update(customer1);

        assertThat(result, equalTo(Optional.of(domain2)));
    }


    @Test
    void testDeleteCustomer() {

    	log.info("delete customer");
        Customer customer = getCustomer();

        when(crudCustomerPort.read(getCustomer())).thenReturn(Optional.of(getCustomer()));

        customerUseCase.delete(customer);

    }

    private Customer getCustomer() {
        return CustomerBuilder.builder()
                .document("11111111111")
                .name("Fulano de Tal")
                .build();
    }
}

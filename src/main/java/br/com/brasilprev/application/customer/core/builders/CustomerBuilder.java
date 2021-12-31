package br.com.brasilprev.application.customer.core.builders;

import br.com.brasilprev.application.customer.core.domain.Address;
import br.com.brasilprev.application.customer.core.domain.Customer;

public class CustomerBuilder {

    private Long id;
    private String document;
    private String name;
    private Address address;

    private CustomerBuilder() {}

    public static CustomerBuilder builder() { return new CustomerBuilder();}

    public CustomerBuilder id(Long id) {
        this.id = id;
        return this;
    }
    public CustomerBuilder document(String document) {
        this.document = document;
        return this;
    }

    public CustomerBuilder name(String name) {
        this.name = name;
        return this;
    }

    public CustomerBuilder address(Address address) {
        this.address = address;
        return this;
    }

    public Customer build() {
       Customer customer = new Customer();
       customer.setDocument(this.document);
       customer.setName(this.name);
       customer.setAddress(this.address);
       return customer;
    }
}

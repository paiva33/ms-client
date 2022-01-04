package br.com.brasilprev.application.customer.adapter.in.web.builder;

import br.com.brasilprev.application.customer.adapter.in.web.payload.AddressResponse;
import br.com.brasilprev.application.customer.adapter.in.web.payload.CustomerResponse;

public class CustomerResponseBuilder {

    private String document;
    private String name;
    private AddressResponse address;

    private CustomerResponseBuilder() {}

    public static CustomerResponseBuilder builder() {return new CustomerResponseBuilder();}

    public CustomerResponseBuilder document(String document) {
        this.document = document;
        return this;
    }

    public CustomerResponseBuilder name(String name) {
        this.name = name;
        return this;
    }

    public CustomerResponseBuilder address(AddressResponse address) {
        this.address = address;
        return this;
    }

    public CustomerResponse build() {
        CustomerResponse response = new CustomerResponse();
        response.setDocument(this.document);
        response.setName(this.name);
        response.setAddress(this.address);
        return response;
    }
}

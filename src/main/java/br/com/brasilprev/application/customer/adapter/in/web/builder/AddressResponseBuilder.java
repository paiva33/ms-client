package br.com.brasilprev.application.customer.adapter.in.web.builder;

import br.com.brasilprev.application.customer.adapter.in.web.payload.AddressResponse;

public class AddressResponseBuilder {

    private String city;
    private Long number;
    private String country;
    private String state;
    private String zipCode;

    private AddressResponseBuilder() {}

    public static AddressResponseBuilder builder() { return new AddressResponseBuilder();}

    public AddressResponseBuilder city(String city) {
        this.city = city;
        return this;
    }

    public AddressResponseBuilder number(Long number) {
        this.number = number;
        return this;
    }

    public AddressResponseBuilder country(String country) {
        this.country = country;
        return this;
    }

    public AddressResponseBuilder state(String state) {
        this.state = state;
        return this;
    }

    public AddressResponseBuilder zipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public AddressResponse build() {
        AddressResponse response = new AddressResponse();
        response.setCity(this.city);
        response.setCountry(this.country);
        response.setNumber(this.number);
        response.setState(this.state);
        response.setZipCode(this.zipCode);
        return response;
    }
}

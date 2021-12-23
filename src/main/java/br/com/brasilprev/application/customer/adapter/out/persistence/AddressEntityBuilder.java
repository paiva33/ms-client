package br.com.brasilprev.application.customer.adapter.out.persistence;

public class AddressEntityBuilder {

    private String street;
    private long number;
    private String district;
    private String city;
    private String state;
    private String zipCode;

    private AddressEntityBuilder() {}

    public static AddressEntityBuilder builder() {return new AddressEntityBuilder();}

    public AddressEntityBuilder street(String street) {
        this.street = street;
        return this;
    }

    public AddressEntityBuilder number(long number) {
        this.number = number;
        return this;
    }

    public AddressEntityBuilder district(String district) {
        this.district = district;
        return this;
    }

    public AddressEntityBuilder state(String state) {
        this.state = state;
        return this;
    }

    public AddressEntityBuilder zipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public AddressEntity build() {
        AddressEntity entity = new AddressEntity();
        entity.setStreet(this.street);
        entity.setCity(this.city);
        entity.setState(this.state);
        entity.setNumber(this.number);
        entity.setZipCode(this.zipCode);
        return entity;
    }
}
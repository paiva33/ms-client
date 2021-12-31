package br.com.brasilprev.application.customer.core.domain;

import lombok.Data;

@Data
public class Address {

    private String street;
    private long number;
    private String country;
    private String city;
    private String state;
    private String zipCode;
}

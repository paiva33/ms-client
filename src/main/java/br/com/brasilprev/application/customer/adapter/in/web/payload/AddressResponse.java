package br.com.brasilprev.application.customer.adapter.in.web.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressResponse {

    private String street;
    private long number;
    private String country;
    private String city;
    private String state;
    private String zipCode;
}

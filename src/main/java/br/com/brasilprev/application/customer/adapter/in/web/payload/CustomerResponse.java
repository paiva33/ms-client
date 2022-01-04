package br.com.brasilprev.application.customer.adapter.in.web.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

@Getter
@Setter
//@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerResponse {

    private Long id;
    private String document;
    private String name;
    private AddressResponse address;
}

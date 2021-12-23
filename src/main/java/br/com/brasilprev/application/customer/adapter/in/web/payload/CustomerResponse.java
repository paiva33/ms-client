package br.com.brasilprev.application.customer.adapter.in.web.payload;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CustomerResponse {

    private String document;
    private String name;
}

package br.com.brasilprev.application.customer.adapter.in.web;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CustomerResponse {

    private String cpf;
    private String name;
}

package br.com.brasilprev.application.customer.adapter.in.web.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerFilterRequest {

    private String nome;
    private String document;
}

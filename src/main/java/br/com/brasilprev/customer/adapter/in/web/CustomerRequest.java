package br.com.brasilprev.customer.adapter.in.web;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CustomerRequest {
	
	private String name;
	private String cpf;
}

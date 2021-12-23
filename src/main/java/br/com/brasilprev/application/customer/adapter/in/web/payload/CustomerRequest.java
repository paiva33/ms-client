package br.com.brasilprev.application.customer.adapter.in.web.payload;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

@Getter
@Setter
@Builder
public class CustomerRequest {
	
	private String name;
	private String document;
}

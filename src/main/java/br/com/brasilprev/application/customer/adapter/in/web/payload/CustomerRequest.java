package br.com.brasilprev.application.customer.adapter.in.web.payload;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CustomerRequest {


	private Long id;
	private String name;
	private String document;
	private AddressRequest address;
}

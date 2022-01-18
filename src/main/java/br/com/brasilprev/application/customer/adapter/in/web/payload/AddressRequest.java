package br.com.brasilprev.application.customer.adapter.in.web.payload;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AddressRequest {
	
	private String street;
	private Long number;
	private String country;
	private String state;
	private String city;
	private String zipCode;
}

package br.com.brasilprev.application.customer.core.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Data
@Builder
public class Customer {

	private Long id;
	private String name;
	private String document;
	private Address address;

}

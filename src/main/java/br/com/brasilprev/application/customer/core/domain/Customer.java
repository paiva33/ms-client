package br.com.brasilprev.application.customer.core.domain;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	private Long id;
	private String name;
	private String document;
	private Address address;

}

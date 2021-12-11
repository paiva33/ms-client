package br.com.brasilprev.customer.application.domain;

import lombok.*;

@Value
@RequiredArgsConstructor
@Builder
public class Customer {

	private Long id;
	private String name;
	private String cpf;
	private Address address;

}

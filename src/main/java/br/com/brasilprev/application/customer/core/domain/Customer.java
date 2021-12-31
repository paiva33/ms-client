package br.com.brasilprev.application.customer.core.domain;

import lombok.*;

@Getter
@Setter
//@Builder
public class Customer {

	private Long id;
	private String name;
	private String document;
	private Address address;

	public Customer() {}

	public Customer(Long id) {
		this.id = id;
	}

	public Customer(String document) {
		this.document = document;
	}
}

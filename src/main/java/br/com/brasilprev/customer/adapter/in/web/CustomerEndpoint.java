package br.com.brasilprev.customer.adapter.in.web;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.compassouol.ms.products.service.to.ProductTO;

import br.com.brasilprev.customer.application.domain.Customer;
import br.com.brasilprev.customer.application.port.in.CustomerUseCase;
import br.com.brasilprev.customer.commons.ResponseBuilder;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class CustomerEndpoint implements BaseEndpoint {
	
	private CustomerUseCase customerUseCase;
	
	
	/**
	 * {@code POST /products } Criação de um produto.
	 * 
	 * @param productTO o produto a ser criado.
	 * @return o {@link ResponseEntity} com status {@code 201 (created) } e o body
	 *         com o novo {@link ProductTO}, ou {@code 400 ( bad request )}
	 */
	@Operation(summary = "Create customer")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Create customer.", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = CustomerRequest.class)) }),
			@ApiResponse(responseCode = "400", description = "Requisição inválida.", content = @Content) })
	@PostMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, consumes = {
			"application/json", "application/xml", "application/x-yaml" })
	public ResponseEntity<CustomerResponse> create(@RequestBody @Valid CustomerRequest request) {
		
		customerUseCase.create(null);
		
		return null;
//		return ResponseBuilder
//				.<CustomerResponse>build()
//				.body(
//						customerUseCase.create(Customer
//													.builder()
//													.cpf(request.getCpf())
//													.name(request.getName())
//												.build()))
//				.created();
	}

}

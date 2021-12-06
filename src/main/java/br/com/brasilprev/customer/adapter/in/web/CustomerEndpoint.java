package br.com.brasilprev.customer.adapter.in.web;

import br.com.brasilprev.customer.application.port.in.CustomerUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class CustomerEndpoint implements BaseEndpoint {
	
	private final CustomerUseCase customerUseCase;
	private final CustomerRequestMapper requestMapper;

	/**
	 * {@code POST /api/v1/customers } Create customer.
	 */
	@Operation(summary = "Create customer")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Create customer.", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = CustomerRequest.class)) }),
			@ApiResponse(responseCode = "400", description = "Requisição inválida.", content = @Content) })
	@PostMapping(produces = { "application/json" }, consumes = {"application/json" })
	public ResponseEntity<CustomerResponse> create(@RequestBody @Valid CustomerRequest request) {
		
		customerUseCase.create(requestMapper.mapRequestToDomain(request));

		
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

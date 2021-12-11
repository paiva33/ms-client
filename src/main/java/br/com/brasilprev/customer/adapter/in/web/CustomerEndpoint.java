package br.com.brasilprev.customer.adapter.in.web;

import br.com.brasilprev.customer.application.port.in.CustomerUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController("customers")
public class CustomerEndpoint implements BaseEndpoint {
	
	private final CustomerUseCase customerUseCase;
	private final CustomerRequestMapper requestMapper;
	private final CustomerResponseMapper responseMapper;

	/**
	 * {@code POST /api/v1/customers } Create customer.
	 */
	@Operation(summary = "Create customer", tags = {"CreateCustomer"})
//	@ApiResponses(value = {
//			@ApiResponse(responseCode = "201", description = "Create customer.", content = {
//					@Content(mediaType = "application/json", schema = @Schema(implementation = CustomerRequest.class)) }),
//			@ApiResponse(responseCode = "400", description = "Requisição inválida.", content = @Content) })
	@ApiResponse(responseCode = "201", description = "Customer Created", content = {@Content(mediaType = "application/json")})
	@ApiResponse(responseCode = "404")
	@ApiResponse(responseCode = "409")
	@ApiResponse(responseCode = "500", description = "Internal Server Error", content = {@Content(mediaType = "application/json")})
	@PostMapping(produces = { "application/json" }, consumes = {"application/json" })
	public ResponseEntity<CustomerResponse> create(@RequestBody @Valid CustomerRequest request) {
		return customerUseCase.create(requestMapper.mapRequestToDomain(request))
							.map(customer -> ResponseEntity.ok().body(responseMapper.mapDomainToRequest(customer)))
							.orElseGet(ResponseEntity.badRequest()::build);
	}

	/**
	 *
	 */
	@Operation(summary = "Update customer", tags = {"UpdateCustomer"})
	@ApiResponse(responseCode = "200")
	@ApiResponse(responseCode = "204")
	@ApiResponse(responseCode = "404")
	@PutMapping
	public ResponseEntity<CustomerResponse> update(@RequestBody @Valid CustomerRequest request) {
		return customerUseCase.update(requestMapper.mapRequestToDomain(request))
					.map(customer -> ResponseEntity.ok().body(responseMapper.mapDomainToRequest(customer)))
					.orElseGet(ResponseEntity.badRequest()::build);
	}

	/**
	 *
	 */
	@Operation(summary = "Delete customer", tags = {"DeleteCustomer"})
	@ApiResponse(responseCode = "200")
	@ApiResponse(responseCode = "404")
	@DeleteMapping
	public ResponseEntity<Void> delete(@RequestBody @Valid CustomerRequest customerRequest) {
		customerUseCase
				.delete(requestMapper.mapRequestToDomain(customerRequest));
		return ResponseEntity.accepted().build();

	}

	@GetMapping("{id}")
	public ResponseEntity<CustomerResponse> findById() {
		return null;
	}

}

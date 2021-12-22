package br.com.brasilprev.application.customer.adapter.in.web;

import br.com.brasilprev.application.customer.core.port.in.CustomerUseCase;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Endpoint Customer
 */
@RequiredArgsConstructor
@RestController("api/customer/v1")
public class CustomerEndpoint implements BaseEndpoint {

	private final CustomerUseCase customerUseCase;
	private final CustomerRequestMapper requestMapper;
	private final CustomerResponseMapper responseMapper;

	/**
	 * {@code POST /api/customer/v1 } Create a new customer.
	 * @param request the CustomerRequest a create.
	 * @return the {@link ResponseEntity<CustomerRequest>} with status {@code 201 (Created)} and with body the new customerResponse,
	 * 			or with status {@code 400 (Bad Request)} if the customer has already an ID.
	 */
	@ApiOperation(value = "Create customer")
	@ApiResponses({
		@ApiResponse(code = 201, message = "Create customer"),
		@ApiResponse(code = 400, message = "Customer has already create")
	})
	@PostMapping(produces = { "application/json" }, consumes = {"application/json" })
	public ResponseEntity<CustomerResponse> create(@RequestBody @Valid CustomerRequest request) {
		return customerUseCase.create(requestMapper.mapRequestToDomain(request))
				.map(customer -> ResponseEntity.ok().body(responseMapper.mapDomainToRequest(customer)))
				.orElseGet(ResponseEntity.badRequest()::build);
	}

	/**
	 * {@code PUT  /api/customer/v1 } : Updates an existing customer.
	 * @param request the customerRequest to update.
	 * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated customerRequest,
	 * or with status {@code 400 (Bad Request)} if the customerRequest is not valid,
	 * or with status {@code 500 (Internal Server Error)} if the customerRequest couldn't be updated.
	 */
	@ApiOperation(value = "Update customer", tags = {"UpdateCustomer"})
	@ApiResponses({
		@ApiResponse(code = 200, message = "Customer updated"),
		@ApiResponse(code = 400, message = "Customer is not valid"),
		@ApiResponse(code = 500, message = "Customer couldn´t be updated.")
	})
	@PutMapping
	public ResponseEntity<CustomerResponse> update(@RequestBody @Valid CustomerRequest request) {
		return customerUseCase.update(requestMapper.mapRequestToDomain(request))
				.map(customer -> ResponseEntity.ok().body(responseMapper.mapDomainToRequest(customer)))
				.orElseGet(ResponseEntity.badRequest()::build);
	}

	/**
	 * {@code GET /api/customer/v1 }
	 * @param request
	 * @return
	 */
	@ApiOperation(value = "Get all customers", tags={"GetAllCustomers"})
	@GetMapping
	public ResponseEntity<CustomerResponse> getAllCustomers(CustomerRequest request) {
		return customerUseCase.read(requestMapper.mapRequestToDomain(request))
				.map(customer -> ResponseEntity.ok().body(responseMapper.mapDomainToRequest(customer)))
				.orElseGet(ResponseEntity.badRequest()::build);
	}


	@GetMapping("{cpf}")
	public ResponseEntity<CustomerResponse> findByCpf(@PathVariable String cpf) {
		return customerUseCase
				.read(requestMapper.mapRequestToDomainWithCpf(cpf))
				.map(customer -> ResponseEntity.ok().body(responseMapper.mapDomainToRequest(customer)))
				.orElseGet(ResponseEntity.badRequest()::build);
	}

	/**
	 * {@code DELETE  /customers/:id} : delete the "id" customer.
	 *
	 * @param id the id of the customerRequest to delete.
	 * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
	 */
	@ApiOperation(value = "Delete customer", tags = {"DeleteCustomer"})
	//@ApiResponse(code = 204)
	@DeleteMapping
	public ResponseEntity delete(@PathVariable Long id) {
		return customerUseCase
				.delete(requestMapper.mapRequesToDomainWithId(id))
				.map(customer -> ResponseEntity.noContent().build())
				.orElseGet(ResponseEntity.badRequest()::build);
	}


}

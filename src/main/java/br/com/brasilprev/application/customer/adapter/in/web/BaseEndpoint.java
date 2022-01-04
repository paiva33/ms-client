package br.com.brasilprev.application.customer.adapter.in.web;

import br.com.brasilprev.application.customer.adapter.in.web.exceptions.ErrorResponse;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

@Api(tags = "Customer Endpoint")
interface BaseEndpoint {
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_GATEWAY)
	default ResponseEntity<ErrorResponse> handleException(MethodArgumentNotValidException exception) {
		List<String> errors = exception.getBindingResult().getFieldErrors().stream()
                .map(x -> MessageFormat.format("`{0}` {1}",
                        x.getField(), x.getDefaultMessage()))
                .collect(Collectors.toList());
		return ResponseEntity
				.badRequest()
				.body(
						ErrorResponse
							.builder()
							.errors(errors)
							.build()							
				);
	}

}

package br.com.brasilprev.customer.adapter.in.web.exceptions;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;

@Builder
@Getter
public class ErrorResponse {
	
	@Singular(value="addError") private List<String> errors;
}

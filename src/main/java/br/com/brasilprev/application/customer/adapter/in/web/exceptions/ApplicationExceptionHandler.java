package br.com.brasilprev.application.customer.adapter.in.web.exceptions;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
	
	private final MessageSource messageSource;

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleException(HttpServletRequest request, Exception ex, Locale locale) {
		ex.printStackTrace();
		ErrorResponse error = ErrorResponse.builder()
									.addError(ex.getMessage())
									.build();
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}

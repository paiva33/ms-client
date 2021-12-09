package br.com.brasilprev.utility;

import org.springframework.http.ResponseEntity;

public class ResponseBuilder<T> {
	
	private T body;
	
	private ResponseBuilder() {}

	public static <T> ResponseBuilder<T> build() {return new ResponseBuilder<>();}
	
	public ResponseBuilder<T> body(T body) {
		this.body = body;
		return this;
	}
	
	public ResponseEntity<T> created() {
		return ResponseEntity.ok(this.body);
	}
}

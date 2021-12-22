package br.com.brasilprev.application.security.adapter.in.web;

import br.com.brasilprev.application.security.core.domain.AccountCredentials;
import br.com.brasilprev.application.security.core.domain.TokenUser;
import br.com.brasilprev.application.security.core.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "AuthenticationEndpoint") 
@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private UserService userService;
	
	@ApiOperation(value = "Authenticates a user and returns a token")
	@SuppressWarnings("rawtypes")
	@PostMapping(value = "/signin", produces = { "application/json"}, consumes = { "application/json"})
	public ResponseEntity<TokenUser> signin(@RequestBody AccountCredentials data) {
			return userService
					.signin(data)
					.map(tokenUser -> ResponseEntity.ok(tokenUser))
					.orElseThrow();
	}
}

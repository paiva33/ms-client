package br.com.brasilprev.application.security.core.service;

import br.com.brasilprev.application.security.adapter.out.persistence.UserPersistenceAdapter;
import br.com.brasilprev.application.security.core.domain.AccountCredentials;
import br.com.brasilprev.application.security.core.domain.TokenUser;
import br.com.brasilprev.application.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider tokenProvider;
    private final UserPersistenceAdapter userPersistenceAdapter;

    public Optional<TokenUser> signin(AccountCredentials data) throws BadCredentialsException {
        var username = data.getUsername();
        var pasword = data.getPassword();

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(username, pasword));

        return userPersistenceAdapter.findByUsername(username)
                .map(user ->
                    Optional.of(TokenUser.builder()
                            .token(tokenProvider.createToken(username, user.getRoles()))
                            .username(username)
                            .build()))
                .orElseThrow(() -> new UsernameNotFoundException("Username" + username + "not found"));
    }
}

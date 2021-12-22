package br.com.brasilprev.application.security.core.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TokenUser {

    private String username;
    private String token;
}

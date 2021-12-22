package br.com.brasilprev.application.security.core.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Getter
@Setter
public class Permission implements GrantedAuthority {

    private Long id;
    private String description;

    @Override
    public String getAuthority() {
        return this.description;
    }
}

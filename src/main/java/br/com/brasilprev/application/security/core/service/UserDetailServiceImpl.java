package br.com.brasilprev.application.security.core.service;

import br.com.brasilprev.application.security.adapter.out.persistence.UserPersistenceAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserPersistenceAdapter userPersistenceAdapter;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userPersistenceAdapter.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found"));
    }
}

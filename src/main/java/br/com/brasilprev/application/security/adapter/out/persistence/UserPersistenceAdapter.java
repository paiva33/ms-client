package br.com.brasilprev.application.security.adapter.out.persistence;

import br.com.brasilprev.application.security.core.domain.User;
import br.com.brasilprev.application.utility.annotations.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
@PersistenceAdapter
public class UserPersistenceAdapter {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public Optional<User> findByUsername(String userName) {
        return this.userRepository.findByUsername(userName)
                .map(userEntity -> userMapper.mapToDomain(userEntity));
    }


}

package br.com.brasilprev.application.security.adapter.out.persistence;

import br.com.brasilprev.application.security.core.domain.User;
import br.com.brasilprev.application.utility.converter.DozerConverter;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserEntity mapToJpaEntity(User user) {
        return DozerConverter.parseObject(user, UserEntity.class);
    }

    public User mapToDomain(UserEntity entity) {
        return DozerConverter.parseObject(entity, User.class);
    }
}

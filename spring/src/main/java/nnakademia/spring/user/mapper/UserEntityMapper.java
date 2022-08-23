package nnakademia.spring.user.mapper;

import nnakademia.spring.user.data.UserEntity;
import nnakademia.spring.user.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserEntityMapper {

    public User fromEntity(UserEntity entity) {
        User user = new User();
        user.setId(entity.getId());
        user.setName(entity.getName());
        return user;
    }

    public List<User> fromEntityList(List<UserEntity> entities) {
        return entities.stream().map(this::fromEntity).toList();
    }

    public UserEntity toUserEntity(User user) {
        UserEntity entity = new UserEntity();
        entity.setId(user.getId());
        entity.setName(user.getName());
        return entity;
    }


}

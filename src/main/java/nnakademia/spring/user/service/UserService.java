package nnakademia.spring.user.service;

import nnakademia.spring.user.data.UserEntity;
import nnakademia.spring.user.data.UserRepository;
import nnakademia.spring.user.domain.User;
import nnakademia.spring.user.mapper.UserEntityMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    private UserEntityMapper mapper;

    public UserService(UserRepository userRepository, UserEntityMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    public List<User> getAll() {
        return mapper.fromEntityList(userRepository.findAll());
    }

    public User save(User user) {

        UserEntity entity = mapper.toUserEntity(user);
        UserEntity saved = this.userRepository.save(entity);
        return mapper.fromEntity(saved);
    }
}

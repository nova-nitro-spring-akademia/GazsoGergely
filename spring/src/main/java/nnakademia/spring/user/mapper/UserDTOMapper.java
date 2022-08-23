package nnakademia.spring.user.mapper;

import nnakademia.spring.user.controller.UserDTO;
import nnakademia.spring.user.data.UserEntity;
import nnakademia.spring.user.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDTOMapper {
    public UserDTO toUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        return userDTO;
    }

    public List<UserDTO> toUserDTOList(List<User> users) {
        return users.stream().map(this::toUserDTO).toList();
    }


    public User fromUserDTO(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        return user;
    }
}

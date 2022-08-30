package com.gergelygazso.springsecuritycustomuserpractice.mapper;


import com.gergelygazso.springsecuritycustomuserpractice.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserDTOMapper {

    public User fromUserDTO(UserDTO userDTO){
        User user = new User();
        user.setName(userDTO.getName());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        return user;
    }

    public UserDTO toUserDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setPassword(user.getPassword());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }

}

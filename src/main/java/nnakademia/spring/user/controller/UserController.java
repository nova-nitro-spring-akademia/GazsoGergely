package nnakademia.spring.user.controller;

import nnakademia.spring.user.data.UserEntity;
import nnakademia.spring.user.domain.User;
import nnakademia.spring.user.mapper.UserDTOMapper;
import nnakademia.spring.user.mapper.UserEntityMapper;
import nnakademia.spring.user.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserDTOMapper mapper;
    private UserService userService;

    public UserController(UserService userService, UserDTOMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @GetMapping
    public GetUsersResponseBody getUsers() {
        List<User> users = userService.getAll();
        GetUsersResponseBody getUsersResponseBody = new GetUsersResponseBody();
        List<UserDTO> userDTOS = mapper.toUserDTOList(users);
        getUsersResponseBody.setData(userDTOS);
        return getUsersResponseBody;
    }

    @PostMapping
    public PostUsersResponseBody postUsers(@RequestBody UserDTO userDTO) {
        System.out.println(userDTO.getName());
        User user = mapper.fromUserDTO(userDTO);
        User saved = this.userService.save(user);
        UserDTO savedDTO = mapper.toUserDTO(saved);
        PostUsersResponseBody response = new PostUsersResponseBody();
        response.setData(savedDTO);
        return response;

    }
}

package com.gergelygazso.springsecuritycustomuserpractice.service;

import com.gergelygazso.springsecuritycustomuserpractice.data.UserRepository;
import com.gergelygazso.springsecuritycustomuserpractice.domain.User;
import com.gergelygazso.springsecuritycustomuserpractice.mapper.UserDTOMapper;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //ITT dierket nem raktam param nélküli konstruktort, mert az csak az Entity-nél kell

//    save User!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public User

}

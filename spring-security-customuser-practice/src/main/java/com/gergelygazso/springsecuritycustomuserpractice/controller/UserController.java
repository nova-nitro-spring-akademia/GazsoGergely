package com.gergelygazso.springsecuritycustomuserpractice.controller;


import com.gergelygazso.springsecuritycustomuserpractice.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    UserService userService;

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    public String postRegister(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String email
    ){

        return "register";
    }

}

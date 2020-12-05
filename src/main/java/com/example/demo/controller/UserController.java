package com.example.demo.controller;

import com.example.demo.dto.UserRegistrationDTO;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public UserEntity save(@RequestBody UserRegistrationDTO registrationDTO) {
        return userService.save(registrationDTO);
    }
}

package com.example.demo.service;

import com.example.demo.dto.UserRegistrationDTO;
import com.example.demo.entity.UserEntity;

public interface UserService {
    UserEntity getById(Long id);
    UserEntity save(UserRegistrationDTO registrationDTO);
}

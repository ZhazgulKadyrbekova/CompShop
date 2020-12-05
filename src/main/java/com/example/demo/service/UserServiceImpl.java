package com.example.demo.service;

import com.example.demo.exception.ResourseNotFoundException;
import com.example.demo.dto.UserRegistrationDTO;
import com.example.demo.entity.Role;
import com.example.demo.entity.UserEntity;

import com.example.demo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    @Override
    public UserEntity getById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourseNotFoundException("User not found"));
    }

    @Override
    public UserEntity save(UserRegistrationDTO registrationDTO) {
        UserEntity user = new UserEntity();
        user.setName(registrationDTO.getName());
        user.setEmail(registrationDTO.getEmail());
        user.setPassword(registrationDTO.getPassword());
        Role role = roleRepository.findByNameContaining("USER");
        user.setRole(role);
        return null;
    }
}
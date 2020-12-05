package com.example.demo.service.impl;

import com.example.demo.entity.CartEntity;
import com.example.demo.exception.ResourseNotFoundException;
import com.example.demo.dto.UserRegistrationDTO;
import com.example.demo.entity.Role;
import com.example.demo.entity.UserEntity;

import com.example.demo.repository.CartRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private CartRepository cartRepository;

    @Override
    public UserEntity getById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourseNotFoundException("User not found"));
    }

    @Override
    public UserEntity save(UserRegistrationDTO registrationDTO) {
        UserEntity user = new UserEntity();
        user.setName(registrationDTO.getName());
        user.setEmail(registrationDTO.getEmail());
        user.setPassword(encoder.encode(registrationDTO.getPassword()));
        Role role = roleRepository.findById(1L).orElse(roleRepository.save(new Role("USER")));
        user.setRole(role);
        user.setActive(true);

        CartEntity cart = new CartEntity();
        cart.setUser(user);
        cartRepository.save(cart);

        return userRepository.save(user);

    }
}
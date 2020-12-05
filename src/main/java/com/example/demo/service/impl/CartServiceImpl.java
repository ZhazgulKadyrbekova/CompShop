package com.example.demo.service.impl;

import com.example.demo.dto.CartDTO;
import com.example.demo.entity.CartEntity;
import com.example.demo.entity.CompEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.exception.ResourseNotFoundException;
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.CompRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CompRepository compRepository;

    @Override
    public CartEntity getById(Long id) {
        return cartRepository.findById(id).orElseThrow(() ->
                new ResourseNotFoundException("Cart id " + id + " not found"));
    }

    @Override
    public CartEntity getByUser(String email) {
        UserEntity userEntity = userRepository.findByEmail(email);
        return cartRepository.findByUser(userEntity);
    }

    @Override
    public CartEntity update(CartDTO cartDTO) {
        CartEntity cartEntity = new CartEntity();
        cartEntity.setUser(userRepository.findByEmail(cartDTO.getUser()));
        List<CompEntity> comps = new ArrayList<>();
        for (Long comp : cartDTO.getComp()) {
            CompEntity compEntity = compRepository.findById(comp).orElse(null);
            if (compEntity != null)
                comps.add(compEntity);
        }
        cartEntity.setCompEntity(comps);
        return cartRepository.save(cartEntity);
    }

    //////////////////////////////////*******************************************************////////////
    @Override
    public CartEntity clear() {
        return null;
    }
}

package com.example.demo.service;

import com.example.demo.dto.CartDTO;
import com.example.demo.entity.CartEntity;

public interface CartService {
    CartEntity getById(Long id);
    CartEntity getByUser(String email);
    CartEntity update(CartDTO cartDTO);
    CartEntity clear();
}

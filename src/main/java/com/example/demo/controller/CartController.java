package com.example.demo.controller;

import com.example.demo.entity.CartEntity;
import com.example.demo.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/cart")
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @PostMapping
    public CartEntity create(@RequestBody CartEntity cart) {
        return cartRepository.save(cart);
    }

}
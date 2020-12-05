package com.example.demo.controller;

import com.example.demo.dto.CartDTO;
import com.example.demo.entity.CartEntity;
import com.example.demo.repository.CartRepository;
import com.example.demo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/{id}")
    public CartEntity getById(@PathVariable Long id) {
        return cartService.getById(id);
    }

    @GetMapping("/{email}")
    public CartEntity getByUser(@PathVariable String email) {
        return cartService.getByUser(email);
    }

    @PutMapping("/update")
    public CartEntity update(@RequestBody CartDTO cartDTO) {
        return cartService.update(cartDTO);
    }

    @PutMapping("/clear")
    public CartEntity clear() {
        return cartService.clear();
    }
}
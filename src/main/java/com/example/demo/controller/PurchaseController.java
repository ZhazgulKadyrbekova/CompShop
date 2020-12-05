package com.example.demo.controller;

import com.example.demo.entity.PurchaseEntity;
import com.example.demo.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.Date;

@RestController
@RequestMapping(path = "/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @PostMapping
    public PurchaseEntity create(@RequestBody PurchaseEntity purchase) {
        return purchaseRepository.save(purchase);
    }
}
package com.example.demo.controller;

import com.example.demo.entity.RamEntity;
import com.example.demo.repository.RamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/ram")
public class RamController {

    @Autowired
    private RamRepository ramRepository;

    @PostMapping
    public RamEntity create(@RequestBody RamEntity ram) {
        return ramRepository.save(ram);
    }
}
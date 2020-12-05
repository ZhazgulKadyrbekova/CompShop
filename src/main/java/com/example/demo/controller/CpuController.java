package com.example.demo.controller;

import com.example.demo.entity.CpuEntity;
import com.example.demo.repository.CpuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/cpu")
public class CpuController {

    @Autowired
    private CpuRepository cpuRepository;

    @PostMapping
    public CpuEntity create(@RequestBody CpuEntity cpu) {
        return cpuRepository.save(cpu);
    }

}
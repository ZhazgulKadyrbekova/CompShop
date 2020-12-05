package com.example.demo.controller;

import com.example.demo.entity.HddEntity;
import com.example.demo.repository.HddRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/hdd")
public class HddController {

    @Autowired
    private HddRepository hddRepository;

    @PostMapping
    public HddEntity create(@RequestBody HddEntity hdd) {
        return hddRepository.save(hdd);
    }
}
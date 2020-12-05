package com.example.demo.service;

import com.example.demo.dto.CompDTO;
import com.example.demo.entity.CompEntity;

import java.util.List;

public interface CompService {
    CompEntity create(CompDTO comp);
    String delete(Long id);
    List<CompEntity> getAll();
    CompEntity getComp(Long id);
}

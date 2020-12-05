package com.example.demo.repository;

import com.example.demo.entity.CompEntity;
import org.springframework.data.repository.CrudRepository;

public interface CompRepository extends CrudRepository<CompEntity, Long> {
}
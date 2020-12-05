package com.example.demo.repository;

import com.example.demo.entity.RamEntity;
import org.springframework.data.repository.CrudRepository;

public interface RamRepository extends CrudRepository<RamEntity, Long> {
}
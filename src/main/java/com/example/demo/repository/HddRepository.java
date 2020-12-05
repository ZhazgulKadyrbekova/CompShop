package com.example.demo.repository;

import com.example.demo.entity.HddEntity;
import org.springframework.data.repository.CrudRepository;

public interface HddRepository extends CrudRepository<HddEntity, Long> {
}
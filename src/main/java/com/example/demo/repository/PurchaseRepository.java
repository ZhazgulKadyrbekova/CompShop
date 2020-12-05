package com.example.demo.repository;

import com.example.demo.entity.PurchaseEntity;
import org.springframework.data.repository.CrudRepository;

public interface PurchaseRepository extends CrudRepository<PurchaseEntity, Long> {
}
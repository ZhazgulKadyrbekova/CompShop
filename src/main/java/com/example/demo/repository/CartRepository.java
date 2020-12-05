package com.example.demo.repository;

import com.example.demo.entity.CartEntity;
import com.example.demo.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<CartEntity, Long> {
    CartEntity findByUser(UserEntity userEntity);
}
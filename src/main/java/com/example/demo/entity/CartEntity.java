package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "cart")
public class CartEntity {

    @Id
    @Column(name = "cart_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;
    
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private UserEntity user;

    @ManyToMany
    @JoinTable(name = "comp_cart", joinColumns = {
            @JoinColumn(name = "comp_id", referencedColumnName = "comp_id")
    }, inverseJoinColumns = {
            @JoinColumn(name = "cart_id", referencedColumnName = "cart_id")
    })
    private List<CompEntity> CompEntity;

}

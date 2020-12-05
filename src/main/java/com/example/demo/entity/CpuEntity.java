package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "cpu")
public class CpuEntity {
       
    @Id 
    @Column(name = "cpu_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "speed", nullable = false)
    private float speed;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    
}
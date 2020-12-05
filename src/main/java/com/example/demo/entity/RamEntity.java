package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "ram")
public class RamEntity {

    @Id
    @Column(name = "ram_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "memory", nullable = false)
    private float memory;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

}
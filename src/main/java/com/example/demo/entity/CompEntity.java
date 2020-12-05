package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "comp")
public class CompEntity {
    @Id
    @Column(name = "comp_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "hdd", referencedColumnName = "hdd_id")
    private HddEntity hdd;

    @ManyToOne
    @JoinColumn(name = "ram", referencedColumnName = "ram_id")
    private RamEntity ram;

    @ManyToOne
    @JoinColumn(name = "cpu", referencedColumnName = "cpu_id")
    private CpuEntity cpu;

}
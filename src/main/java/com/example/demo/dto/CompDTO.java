package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CompDTO {
   private String name;
   private Long hdd;
   private Long ram;
   private Long cpu;
}

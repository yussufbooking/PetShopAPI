package com.petshop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PetDTO2 {
    private Integer id;
    private String name;
    private String species;
    private Integer age;
    private double price;
}


package com.petshop.PetShopAPI.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Pets")
@Data // GETTER/SETTERS generation
@AllArgsConstructor
@NoArgsConstructor
public class Pet {
    @Id
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String species;
    private String breed;
    private Integer age;

    @Column(nullable = false)
    private boolean isSold;

    @Column(nullable = false)
    private double price;
}

//ENTITY(50 all values in db) VS DTO(can send specfic values e.g all values but id)
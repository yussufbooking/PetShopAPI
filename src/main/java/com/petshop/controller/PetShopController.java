package com.petshop.controller;

import com.petshop.dto.PetDto;
import com.petshop.entity.Pet;
import com.petshop.service.PetShopService;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor

public class PetShopController {
    private final PetShopService petShopService;

    @GetMapping("/pets")
    @ResponseStatus(HttpStatus.OK)
    public List<PetDto> getAllPets(){
        return petShopService.getAllPets();
    }

    @GetMapping("/pet/{petID}")
    @ResponseStatus(HttpStatus.OK)
    public PetDto getPetByID(@PathVariable Integer petID){
        return petShopService.getPetByID(petID);
    }



    @PostMapping("/pet")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String>  addPet(@RequestBody Pet pet){
        petShopService.addPet(pet);
        return ResponseEntity.ok("Pet added successfully");
    }

    @DeleteMapping("/pet/{petID}")
    @ResponseStatus (HttpStatus.OK)
    public ResponseEntity<String> deletePet(@PathVariable Integer petID){
        petShopService.deletePet(petID);
        return ResponseEntity.ok("Pet deleted successfully");
    }

    @PutMapping("/pet/{petID}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String>  updatePet(@PathVariable("petID") Integer id, @RequestBody Pet pet) {
         petShopService.updatePet(id, pet);
        return ResponseEntity.ok("Pet updated successfully");

    }

}


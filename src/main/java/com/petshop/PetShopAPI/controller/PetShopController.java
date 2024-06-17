package com.petshop.PetShopAPI.controller;

import com.petshop.PetShopAPI.dto.PetDto;
import com.petshop.PetShopAPI.entity.Pet;
import com.petshop.PetShopAPI.service.PetShopService;
import lombok.AllArgsConstructor;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public Pet addPet(@RequestBody Pet pet){
        Pet savedPet = petShopService.addPet(pet);
        return savedPet;
    }

    @DeleteMapping("/pet/{petID}")
    @ResponseStatus (HttpStatus.OK)
    public void deletePet(@PathVariable Integer petID){
        petShopService.deletePet(petID);
    }

    @PutMapping("/pet/{petID}")
    @ResponseStatus(HttpStatus.OK)
    public Pet updatePet(@PathVariable("petID") Integer id, @RequestBody Pet pet) {
        return petShopService.updatePet(id, pet);
    }

}


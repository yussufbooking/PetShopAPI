package com.petshop.PetShopAPI.service;

import com.petshop.PetShopAPI.dto.PetDto;
import com.petshop.PetShopAPI.entity.Pet;
import com.petshop.PetShopAPI.repository.PetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PetShopService {
    private final PetRepository petRepository;

    public List<PetDto> getAllPets(){
        return convertToList((List<Pet>) petRepository.findAll());
    }
    private List<PetDto> convertToList(List<Pet> pets){
        return pets.stream().map(pet -> {
            if(pet != null){
                return PetDto.builder()
                        .name(pet.getName())
                        .species(pet.getSpecies())
                        .age(pet.getAge())
                        .price(pet.getPrice())
                        .build();
            }
            return new PetDto();
        }).collect(Collectors.toList());
    }

    public PetDto getPetByID(Integer petID) {
        Optional<Pet> pet_optional =  petRepository.findById(petID);
        PetDto pet = pet_optional.map(pet1 ->
            new PetDto(pet1.getName(),pet1.getSpecies(),pet1.getAge(),pet1.getPrice())
        ).orElse(null);
        if(pet == null){
            throw new RuntimeException("No pet found");
        }
        return pet;
    }

    public Pet addPet(Pet pet){
        return petRepository.save(pet);
    }

    public void deletePet(Integer id){
        if(petRepository.existsById(id)){
            petRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Pet not found");
        }
    }

    public Pet updatePet(Integer id, Pet updatedPet) {
        return petRepository.findById(id).map(pet -> {
            pet.setName(updatedPet.getName());
            pet.setSpecies(updatedPet.getSpecies());
            pet.setBreed(updatedPet.getBreed());
            pet.setAge(updatedPet.getAge());
            pet.setPrice(updatedPet.getPrice());
            pet.setSold(updatedPet.isSold());
            pet.setGender(updatedPet.getGender());
            return petRepository.save(pet);
        }).orElseThrow(() -> new IllegalArgumentException("Pet not found with id " + id));
    }

}

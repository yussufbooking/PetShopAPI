package com.petshop.PetShopAPI.service;

import com.petshop.PetShopAPI.dto.PetDto;
import com.petshop.PetShopAPI.entity.Pet;
import com.petshop.PetShopAPI.repository.PetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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
}

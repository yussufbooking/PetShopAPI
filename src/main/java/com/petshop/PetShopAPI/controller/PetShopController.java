package com.petshop.PetShopAPI.controller;

import com.petshop.PetShopAPI.dto.PetDto;
import com.petshop.PetShopAPI.service.PetShopService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@AllArgsConstructor
public class PetShopController {
    private PetShopService petShopService;


    @GetMapping("/pets")
    @ResponseStatus(HttpStatus.OK)
    public List<PetDto> getAllPets(){
        return petShopService.getAllPets();
    }

}


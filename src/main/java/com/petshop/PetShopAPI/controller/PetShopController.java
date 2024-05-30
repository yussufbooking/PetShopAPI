package com.petshop.PetShopAPI.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetShopController {

    @GetMapping("/")
    public String helloWorld(){
        return "Hello World";
    }

}

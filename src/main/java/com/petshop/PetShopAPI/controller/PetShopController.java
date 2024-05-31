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

// error status
// 2xx status
// check if table contains correct values i.e name,species e.t.c

package com.petshop.PetShopAPI.repository;

import com.petshop.PetShopAPI.entity.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends CrudRepository<Pet,Integer> {
    // interface vs class, class defines all functions, interface not implementation of function
    // interface = bundle of functions
    // contract of what class can do without saying how to do it
}

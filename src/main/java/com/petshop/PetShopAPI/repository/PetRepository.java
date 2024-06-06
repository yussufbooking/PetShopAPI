package com.petshop.PetShopAPI.repository;

import com.petshop.PetShopAPI.entity.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PetRepository extends CrudRepository<Pet,Integer> {
}

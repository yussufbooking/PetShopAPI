package com.petshop.PetShopAPI

import com.fasterxml.jackson.databind.ObjectMapper
import com.petshop.PetShopAPI.controller.PetShopController
import com.petshop.PetShopAPI.dto.PetDTO2
import com.petshop.PetShopAPI.dto.PetDto
import com.petshop.PetShopAPI.entity.Pet
import com.petshop.PetShopAPI.service.PetShopService
import groovy.json.JsonSlurper
import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(PetShopController)
class PetShopControllerTest extends Specification {
    @Autowired
    private MockMvc mockMvc

    @Autowired
    private ObjectMapper objectMapper

    @SpringBean
    private PetShopService petShopService = Mock()


    def "should return empty list given no pets exist in database"(){
        given:
        petShopService.getAllPets() >> []
        when:
        def result = mockMvc.perform(get("/pets"))
        then:
        result.andExpect(status().isOk()).andExpect(content().json(objectMapper.writeValueAsString([])))
    }

    def "should return list of pets if pets exists in the database"(){
        given:
        def pets = [PetDto.builder().name("Bob").species("Cat").age(5).price(10).build() ,
                    PetDto.builder().name("Jack").species("Dog").age(1).price(55).build()]
        petShopService.getAllPets() >> pets
        when:
        def result = mockMvc.perform(get("/pets"))
        then:
        result.andExpect(status().isOk()).andExpect(content().json(objectMapper.writeValueAsString(pets)))
    }

    def "should return empty list when given petID does not exist in database"(){
        given:
        petShopService.getPetByID(99) >> null
        println(petShopService.getPetByID(99))
        when:
        def result = mockMvc.perform(get("/pet/99"))
        then:
        result.andExpect(content().string(""))

    }

    def "should return correct pet when given petID"(){
        given:
        Integer PetID = 1
        def pet = new PetDto( name: "Fluffy" , species: "Cat" , age:10,price:100)

        petShopService.getPetByID(1) >> pet
        println(petShopService.getPetByID(1))
        when:
       def result = mockMvc.perform(get("/pet/1"))
        then:
        def resposeBody = new JsonSlurper().parseText(result)
        println(resposeBody)
        result.andExpect(status().isOk()).andExpect(content().string(""));

    }
}

package com.petshop.PetShopAPI

import com.fasterxml.jackson.databind.ObjectMapper
import com.petshop.PetShopAPI.controller.PetShopController
import com.petshop.PetShopAPI.dto.PetDto
import com.petshop.PetShopAPI.service.PetShopService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
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
    @Autowired
    private PetShopService petShopService

    def "should return Hello World"(){
        when:
        def result = mockMvc.perform(get("/"))

        then:
        result.andExpect(status().isOk())
                .andExpect(content().string("Hello World"))
    }

    def "should return empty list given no pets exist in database"(){
        given:
        petShopService.getAllPets() >> objectMapper.writeValueAsString([])
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
}

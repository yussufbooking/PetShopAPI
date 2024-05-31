package com.petshop.PetShopAPI

import com.petshop.PetShopAPI.controller.PetShopController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest(classes = PetShopApiApplication.class)
class PetShopControllerTest extends Specification {
    @Autowired
    MockMvc mockMvc
//    PetShopController petShopController
//    petShopService petShopService

//    def setup(){
//        petShopController = new PetShopController(petShopService)
//        mockMvc = MockMvcBuilders.standaloneSetup()
//    }

    def "should return successful response given list of pets return by service"(){
        given:
        def expectedResponse = ""
        when:
        def actualResult  = mockMvc.perform(get("/pets"))
        then:
        actualResult.andExpect(content().string(expectedResponse))
        actualResult.andExpect(status().string())

    }
}


//Controller() -> Service (business logic) -> Repo(model)
//given when then
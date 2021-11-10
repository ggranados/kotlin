package com.ggranados.sercretsanta.api

import com.fasterxml.jackson.databind.ObjectMapper
import com.ggranados.sercretsanta.api.model.Person
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@SpringBootTest
@AutoConfigureMockMvc
internal class SecretSantaServiceApplicationTest{

    @Autowired
    lateinit var mockMvc: MockMvc;

    @Test
    @DisplayName("givenSavePerson")
    @Throws(Exception::class)
    fun givenSavePerson() {

        var personTest =  Person(1,"","","","",Person.PersonaStatus.REGISTERED);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/persons/")
            .contentType(MediaType.APPLICATION_JSON)
            .content(asJsonString(personTest))).andDo(print())
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
    }



    fun asJsonString(obj: Person): String {
        return try {
            ObjectMapper().writeValueAsString(obj)
        } catch (e: java.lang.Exception) {
            throw RuntimeException(e)
        }
    }
}
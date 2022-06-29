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
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@SpringBootTest
@AutoConfigureMockMvc
internal class SecretSantaServiceApplicationTest{

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    @DisplayName("givenPersonWhenSavedThenPersonReturned")
    @Throws(Exception::class)
    fun givenPersonWhenSavedThenPersonReturned() {

        //TODO: assign relations
        //val eventTest = Event(1,"Secret Santa 2021", LocalDate.of(2021,11,24))
        //var teamTest = Team(1, "team1")
        val personTest =  Person(1,"","","","", Person.PersonaStatus.REGISTERED, null)

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/team/1/persons/")
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
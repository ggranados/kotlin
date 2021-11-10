package com.ggranados.sercretsanta.api.controller

import com.ggranados.sercretsanta.api.model.Person
import com.ggranados.sercretsanta.api.service.PersonaServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/persons")
@CrossOrigin("*")
class PersonController {

    @Autowired
    lateinit var  personServiceAPI: PersonaServiceImpl

    @GetMapping
    fun getAll() : MutableList<Person>? {
        return personServiceAPI.all
    }

    @PostMapping
    fun save(@RequestBody person: Person) : ResponseEntity<Person>{
        var obj = personServiceAPI.save(person);
        return ResponseEntity<Person>(person, HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) : ResponseEntity<Person>{
        return if (personServiceAPI.get(id) != null) {
            personServiceAPI.delete(id);
            ResponseEntity<Person>(HttpStatus.NO_CONTENT);
        }else{
            ResponseEntity<Person>(HttpStatus.NOT_FOUND);
        }
    }
}
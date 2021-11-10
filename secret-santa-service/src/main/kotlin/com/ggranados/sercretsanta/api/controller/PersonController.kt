package com.ggranados.sercretsanta.api.controller

import com.ggranados.sercretsanta.api.model.Person
import com.ggranados.sercretsanta.api.service.PersonaServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/v1/persons")
@CrossOrigin("*")
class PersonController {

    @Autowired
    lateinit var  personServiceAPI: PersonaServiceImpl

    @GetMapping
    fun getAllPersons() : MutableList<Person>? {
        return personServiceAPI.all
    }

    @PostMapping
    fun savePerson(@RequestBody person: Person) : ResponseEntity<Person>{
        var p = personServiceAPI.save(person);
        return ResponseEntity<Person>(p, HttpStatus.OK)
    }

    @PutMapping("/{id}")
    fun updatePerson(@PathVariable id: Long, @RequestBody person: Person) : ResponseEntity<Person>{
        var persona = personServiceAPI[id];
        return if (Objects.nonNull(persona)) {
            var p = personServiceAPI.save(person);
            ResponseEntity<Person>(p,HttpStatus.OK);
        }else{
            ResponseEntity<Person>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    fun getPersona(@PathVariable id: Long) : ResponseEntity<Person>{

        var persona = personServiceAPI[id];
        return if (Objects.nonNull(persona)) {
            ResponseEntity<Person>(persona,HttpStatus.OK);
        }else{
            ResponseEntity<Person>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) : ResponseEntity<Person>{
        return if (personServiceAPI[id] != null) {
            personServiceAPI.delete(id);
            ResponseEntity<Person>(HttpStatus.NO_CONTENT);
        }else{
            ResponseEntity<Person>(HttpStatus.NOT_FOUND);
        }
    }
}
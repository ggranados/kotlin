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
    lateinit var  serviceAPI: PersonaServiceImpl

    @GetMapping
    fun getAllPersons() : MutableList<Person>? {
        return serviceAPI.all
    }

    @PostMapping
    fun savePerson(@RequestBody personParam: Person) : ResponseEntity<Person>{
        val personSaved = serviceAPI.save(personParam);
        return ResponseEntity<Person>(personSaved, HttpStatus.OK)
    }

    @PutMapping("/{id}")
    fun updatePerson(@PathVariable id: Long, @RequestBody personParam: Person) : ResponseEntity<Person>{
        val personFound = serviceAPI[id];
        return if (Objects.nonNull(personFound)) {
            val personSaved = serviceAPI.save(personParam);
            ResponseEntity<Person>(personSaved,HttpStatus.OK);
        }else{
            ResponseEntity<Person>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    fun getPersona(@PathVariable id: Long) : ResponseEntity<Person>{

        val personFound = serviceAPI[id];
        return if (Objects.nonNull(personFound)) {
            ResponseEntity<Person>(personFound,HttpStatus.OK);
        }else{
            ResponseEntity<Person>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) : ResponseEntity<Person>{
        return if (serviceAPI[id] != null) {
            serviceAPI.delete(id);
            ResponseEntity<Person>(HttpStatus.NO_CONTENT);
        }else{
            ResponseEntity<Person>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("{idPerson}/assignation/{idAssigned}")
    fun assignPerson(@PathVariable("idPerson") idPerson: Long,
                     @PathVariable("idAssigned") idAssigned: Long) : ResponseEntity<Person>{

        val personAssigned = (serviceAPI.assign(idPerson, idAssigned));

        return ResponseEntity<Person>(personAssigned!!,HttpStatus.OK);
    }
}
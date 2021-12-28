package com.ggranados.sercretsanta.api.team

import com.ggranados.sercretsanta.api.person.Person
import com.ggranados.sercretsanta.api.person.PersonaServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/teams")
@CrossOrigin("*")
class TeamController {

    @Autowired
    lateinit var teamService: TeamService

    @Autowired
    lateinit var  personaService: PersonaServiceImpl

    @GetMapping("{teamId}")
    fun getTeam(@PathVariable teamId : Long) : ResponseEntity<Team>{

        val team = teamService[teamId] ?: return ResponseEntity(HttpStatus.NOT_FOUND)

        return ResponseEntity<Team>(team,HttpStatus.OK);
    }

    @PostMapping("{teamId}/persons")
    @Transactional
    fun savePerson(@PathVariable teamId : Long, @RequestBody personParam: Person) : ResponseEntity<Person>{
        val teamParent = teamService[teamId] ?: return ResponseEntity(HttpStatus.NOT_FOUND)
        val personSaved = personaService.save(personParam)

        teamParent.members.add(personSaved)
        teamService.save(teamParent)

        return ResponseEntity<Person>(personSaved, HttpStatus.OK)
    }


}
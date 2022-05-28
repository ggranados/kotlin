package com.ggranados.sercretsanta.api.controller

import com.ggranados.sercretsanta.api.model.Team
import com.ggranados.sercretsanta.api.service.TeamService
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

    @GetMapping("{teamId}")
    fun getTeam(@PathVariable teamId : Long) : ResponseEntity<Team>{

        val team = teamService[teamId] ?: return ResponseEntity(HttpStatus.NOT_FOUND)

        return ResponseEntity<Team>(team,HttpStatus.OK)
    }

    @GetMapping
    fun getTeams() : MutableList<Team>?{
        return teamService.all
    }

    @PostMapping()
    @Transactional
    fun saveTeam(@RequestBody team: Team): ResponseEntity<Team> {
        val teamSaved = teamService.save(team)
        return ResponseEntity<Team>(teamSaved, HttpStatus.ACCEPTED)
    }

}
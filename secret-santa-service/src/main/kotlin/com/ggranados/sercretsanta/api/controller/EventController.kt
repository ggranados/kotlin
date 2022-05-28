package com.ggranados.sercretsanta.api.controller

import com.ggranados.sercretsanta.api.service.EventService
import com.ggranados.sercretsanta.api.model.Event
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/v1/events")
@CrossOrigin("*")
class EventController {

    @Autowired
    lateinit var eventService: EventService

    @PostMapping
    fun saveEvent(@RequestBody event: Event) : ResponseEntity<Event>{
     val eventSaved = eventService.save(event)
     return ResponseEntity<Event>(eventSaved, HttpStatus.ACCEPTED)
    }

    @GetMapping
    fun getAllEvents() : MutableList<Event>?{
        return eventService.all
    }

    @GetMapping("/{id}")
    fun getEvent(@PathVariable id: Long) : ResponseEntity<Event>{
        val eventFound = eventService[id]
        return if(Objects.nonNull(eventFound)){
            ResponseEntity(eventFound, HttpStatus.OK)
        }else{
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @DeleteMapping("{/{id}}")
    fun deleteEvent(@PathVariable id: Long) : ResponseEntity<Event>{
        val eventFound = eventService[id]
        return if(Objects.nonNull(eventFound)){
            eventService.delete(id)
            ResponseEntity(eventFound, HttpStatus.OK)
        }else{
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }


}
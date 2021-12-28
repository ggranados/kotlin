package com.ggranados.sercretsanta.api.event

import com.ggranados.sercretsanta.api.common.GenericServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

@Service
class EventServiceImpl : GenericServiceImpl<Event, Long>(), EventService {

    @Autowired
    lateinit var eventRepository: EventRepository

    override val dao: CrudRepository<Event, Long>
        get() =  eventRepository
}
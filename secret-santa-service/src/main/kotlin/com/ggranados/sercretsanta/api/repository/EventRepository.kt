package com.ggranados.sercretsanta.api.repository

import com.ggranados.sercretsanta.api.model.Event
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface EventRepository : CrudRepository<Event,Long>{
}
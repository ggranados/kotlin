package com.ggranados.sercretsanta.api.event

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface EventRepository : CrudRepository<Event,Long>{
}
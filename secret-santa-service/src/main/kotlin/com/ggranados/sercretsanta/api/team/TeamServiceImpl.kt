package com.ggranados.sercretsanta.api.team

import com.ggranados.sercretsanta.api.common.GenericServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

@Service
class TeamServiceImpl : GenericServiceImpl<Team, Long>(), TeamService {

    @Autowired
    lateinit var eventRepository: TeamRepository

    override val dao: CrudRepository<Team, Long>
        get() =  eventRepository
}
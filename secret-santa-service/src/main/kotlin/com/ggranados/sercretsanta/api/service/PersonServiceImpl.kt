package com.ggranados.sercretsanta.api.service

import com.ggranados.sercretsanta.api.common.GenericServiceImpl
import com.ggranados.sercretsanta.api.model.Person
import com.ggranados.sercretsanta.api.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

@Service
class PersonaServiceImpl : GenericServiceImpl<Person, Long>(), PersonaServiceAPI {

    @Autowired
    lateinit var personaRepository: PersonRepository

    override val dao: CrudRepository<Person, Long>
        get() =  personaRepository

}
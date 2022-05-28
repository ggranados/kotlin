package com.ggranados.sercretsanta.api.service

import com.ggranados.sercretsanta.api.model.Person
import com.ggranados.sercretsanta.api.repository.PersonRepository
import com.ggranados.sercretsanta.api.model.builder.PersonBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class PersonaServiceImpl : GenericServiceImpl<Person, Long>(), PersonaService {

    @Autowired
    lateinit var personaRepository: PersonRepository

    override val dao: CrudRepository<Person, Long>
        get() =  personaRepository

    fun assign(idPerson: Long, idAssigned: Long): Person? {
        val personRequested = this[idPerson]
        val assignedRequested = this[idAssigned]

        return if (Objects.nonNull(personRequested).and(Objects.nonNull(assignedRequested))) {
            val assigned = PersonBuilder.getPersonAssigned(assignedRequested!!)
            val person = PersonBuilder.getPersonWithAssignation(personRequested!!, assigned)
            this.save(person)
            person
        }else null
    }
}
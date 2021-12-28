package com.ggranados.sercretsanta.api.person

import com.ggranados.sercretsanta.api.common.GenericServiceImpl
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
        val personRequested = this[idPerson];
        val assignedRequested = this[idAssigned];

        return if (Objects.nonNull(personRequested).and(Objects.nonNull(assignedRequested))) {
            val assigned = PersonUtils.getPersonAssigned(assignedRequested!!);
            val person = PersonUtils.getPersonWithAssignation(personRequested!!, assigned);
            this.save(person);
            person;
        }else null
    }
}
package com.ggranados.sercretsanta.api.model.builder

import com.ggranados.sercretsanta.api.model.Person
import com.ggranados.sercretsanta.api.model.Person.PersonaStatus.ASSIGNED

class PersonBuilder {
    companion object{

        @JvmStatic
        fun getPersonWithAssignation(person: Person, assigned: Person) : Person {

            //TODO:add relations
            //val event = Event(0, "event", LocalDate.now())

            //val team = Team(0,"team")

            val p = Person(
                person.id,
                person.name,
                person.lastName,
                person.email,
                person.phone,
                person.status,
                assigned
            )
            return p
        }

        @JvmStatic
        fun getPersonAssigned(person: Person) : Person {

            //TODO:add relations
            //val event = Event(0, "event", LocalDate.now())

            //val team = Team(0,"team")

            val p = Person(
                person.id,
                person.name,
                person.lastName,
                person.email,
                person.phone,
                ASSIGNED,
                person.assigned
            )
            return p
        }

    }
}

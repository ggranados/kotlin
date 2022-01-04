package com.ggranados.sercretsanta.api.person

import com.ggranados.sercretsanta.api.event.Event
import com.ggranados.sercretsanta.api.person.Person.PersonaStatus.*
import com.ggranados.sercretsanta.api.team.Team
import java.time.LocalDate

class PersonUtils {
    companion object{

        @JvmStatic
        fun getPersonWithAssignation(person: Person, assigned: Person) : Person {

            val event = Event(0, "event", LocalDate.now())

            val team = Team(0,"team")

            val p = Person(
                person.id,
                person.name,
                person.lastName,
                person.email,
                person.phone,
                person.status,
                assigned
            );
            return p;
        }

        @JvmStatic
        fun getPersonAssigned(person: Person) : Person {

            val event = Event(0, "event", LocalDate.now())

            val team = Team(0,"team")

            val p = Person(
                person.id,
                person.name,
                person.lastName,
                person.email,
                person.phone,
                ASSIGNED,
                person.assigned
            );
            return p;
        }

    }
}

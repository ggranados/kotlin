package com.ggranados.sercretsanta.api.model

import com.ggranados.sercretsanta.api.model.Person.PersonaStatus.*

class PersonUtils {
    companion object{

        @JvmStatic
        fun getPersonWithAssignation(person: Person, assigned: Person) : Person{

            val p = Person(
                person.id,
                person.name,
                person.lastName,
                person.email,
                person.phone,
                person.status,
                assigned,
                person.event,
                person.team,
                person.options
            );
            return p;
        }

        @JvmStatic
        fun getPersonAssigned(person: Person) : Person{

            val p = Person(
                person.id,
                person.name,
                person.lastName,
                person.email,
                person.phone,
                ASSIGNED,
                person.assigned,
                person.event,
                person.team,
                person.options
            );
            return p;
        }

    }
}

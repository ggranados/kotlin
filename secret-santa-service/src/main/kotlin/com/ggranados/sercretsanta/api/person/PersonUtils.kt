package com.ggranados.sercretsanta.api.person

import com.ggranados.sercretsanta.api.person.Person.PersonaStatus.*

class PersonUtils {
    companion object{

        @JvmStatic
        fun getPersonWithAssignation(person: Person, assigned: Person) : Person {

            val p = Person(
                person.id,
                person.name,
                person.lastName,
                person.email,
                person.phone,
                person.status,
                assigned,
                person.options
            );
            return p;
        }

        @JvmStatic
        fun getPersonAssigned(person: Person) : Person {

            val p = Person(
                person.id,
                person.name,
                person.lastName,
                person.email,
                person.phone,
                ASSIGNED,
                person.assigned,
                person.options
            );
            return p;
        }

    }
}

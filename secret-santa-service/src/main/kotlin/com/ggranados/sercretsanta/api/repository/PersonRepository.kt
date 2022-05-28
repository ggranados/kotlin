package com.ggranados.sercretsanta.api.repository

import com.ggranados.sercretsanta.api.model.Person
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository: CrudRepository<Person, Long> {
}
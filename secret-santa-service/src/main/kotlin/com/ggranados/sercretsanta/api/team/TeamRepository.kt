package com.ggranados.sercretsanta.api.team

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TeamRepository : CrudRepository<Team,Long>{
}
package com.ggranados.sercretsanta.api.repository

import com.ggranados.sercretsanta.api.model.Team
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TeamRepository : CrudRepository<Team,Long>{
}
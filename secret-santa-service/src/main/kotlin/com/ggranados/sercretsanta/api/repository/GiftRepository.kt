package com.ggranados.sercretsanta.api.repository

import com.ggranados.sercretsanta.api.model.Gift
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface GiftRepository : CrudRepository<Gift, Long>{
}
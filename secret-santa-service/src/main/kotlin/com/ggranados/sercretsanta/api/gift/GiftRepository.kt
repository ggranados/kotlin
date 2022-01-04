package com.ggranados.sercretsanta.api.gift

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface GiftRepository : CrudRepository<Gift, Long>{
}
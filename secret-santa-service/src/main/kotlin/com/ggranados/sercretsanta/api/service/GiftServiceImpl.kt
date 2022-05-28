package com.ggranados.sercretsanta.api.service

import com.ggranados.sercretsanta.api.repository.GiftRepository
import com.ggranados.sercretsanta.api.model.Gift
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

@Service
class GiftServiceImpl : GenericServiceImpl<Gift, Long>(), GiftService {

    @Autowired
    lateinit var giftRepository: GiftRepository

    override val dao: CrudRepository<Gift, Long>
        get() =  giftRepository
}
package com.ggranados.sercretsanta.api.gift

import com.ggranados.sercretsanta.api.common.GenericServiceImpl
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
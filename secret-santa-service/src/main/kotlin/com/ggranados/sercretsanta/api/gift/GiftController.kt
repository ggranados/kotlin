package com.ggranados.sercretsanta.api.gift

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/v1/gifts")
@CrossOrigin("*")
class GiftController {

    @Autowired
    lateinit var giftService: GiftService

    @PostMapping
    fun saveGift(@RequestBody gift: Gift) : ResponseEntity<Gift>{
        val giftSaved = giftService.save(gift)
        return ResponseEntity<Gift>(giftSaved,HttpStatus.ACCEPTED)
    }

    @GetMapping
    fun getGifts() : MutableList<Gift>?{
        return giftService.all
    }

    @GetMapping("/{id}")
    fun getGift(@PathVariable id: Long) : ResponseEntity<Gift>{
        val giftFound = giftService[id]
        return if(Objects.nonNull(giftFound))
            ResponseEntity<Gift>(giftFound,HttpStatus.OK)
        else
            ResponseEntity(HttpStatus.NOT_FOUND)
    }

}
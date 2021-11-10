package com.ggranados.sercretsanta.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SecretSantaServiceApplication

fun main(args: Array<String>) {
	runApplication<SecretSantaServiceApplication>(*args)
}

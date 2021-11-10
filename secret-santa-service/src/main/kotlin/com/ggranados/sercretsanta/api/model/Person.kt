package com.ggranados.sercretsanta.api.model

import javax.persistence.*

@Entity
data class Person (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column
    val name: String = "",

    @Column(name="lastname")
    val lastName: String = "",

    @Column
    val email: String = "",

    @Column
    val phone: String = "",

    @Column
    val status: PersonaStatus

){

    enum class PersonaStatus {
        REGISTERED, W_RECOMMENDATION, W_ASSIGNATION, SELECTED,
    }
}
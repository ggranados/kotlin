package com.ggranados.sercretsanta.api.model

import javax.persistence.*

@Entity
@Table( name = "teams")
class Team(
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    val id: Long = 0,

    @Column
    val name: String = "",

) {

}
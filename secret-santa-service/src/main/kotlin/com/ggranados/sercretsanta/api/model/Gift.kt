package com.ggranados.sercretsanta.api.model

import javax.persistence.*

@Entity
@Table( name = "gift" )
class Gift(
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    val id: Long,

    @Column( name = "name" )
    val name: String,

    @Column ( name = "description" )
    val description: String,


) {

}
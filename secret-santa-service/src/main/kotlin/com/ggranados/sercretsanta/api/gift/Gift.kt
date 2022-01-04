package com.ggranados.sercretsanta.api.gift

import com.ggranados.sercretsanta.api.person.Person
import javax.persistence.*

@Entity
@Table( name = "gifts" )
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
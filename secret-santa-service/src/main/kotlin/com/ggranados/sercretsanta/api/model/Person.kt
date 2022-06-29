package com.ggranados.sercretsanta.api.model

import org.springframework.lang.NonNull
import javax.persistence.*

@Entity
@Table(name= "persons")
class  Person (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column( name = "name")
    @NonNull
    val name: String = "",

    @Column( name = "lastname")
    val lastName: String = "",

    @Column( name = "email", unique = true)
    @NonNull
    val email: String = "",

    @Column( name = "phone")
    val phone: String = "",

    @Column( name = "status")
    val status: PersonaStatus,

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "assigned_id", referencedColumnName = "id")
    val assigned: Person?

    ){

    enum class PersonaStatus {
        REGISTERED, ASSIGNED
    }

}
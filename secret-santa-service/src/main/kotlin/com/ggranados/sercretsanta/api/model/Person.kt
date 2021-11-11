package com.ggranados.sercretsanta.api.model

import org.springframework.lang.NonNull
import javax.persistence.*

@Entity
@Table(name= "person")
data class Person (
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
    val assigned: Person?,

    @ManyToOne
    @JoinColumn( name = "event_id")
    val event: Event,

    @ManyToOne
    @JoinColumn( name = "team_id")
    val team: Team,

    @OneToMany(
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    )
    @JoinColumn( name = "person_id" )
    val options: List<Gift> = ArrayList<Gift>()

    ){

    enum class PersonaStatus {
        REGISTERED, ASSIGNED
    }

}
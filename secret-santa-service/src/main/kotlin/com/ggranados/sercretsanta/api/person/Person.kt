package com.ggranados.sercretsanta.api.person

import com.ggranados.sercretsanta.api.gift.Gift
import com.ggranados.sercretsanta.api.team.Team
import org.springframework.lang.NonNull
import javax.persistence.*

@Entity
@Table(name= "person")
data class  Person (
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

    @OneToMany(
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    )
    @JoinColumn(
        name = "person_id",
        referencedColumnName = "id" )
    var options: MutableList<Gift> = ArrayList<Gift>()

    ){

    enum class PersonaStatus {
        REGISTERED, ASSIGNED
    }

}
package com.ggranados.sercretsanta.api.team

import com.ggranados.sercretsanta.api.event.Event
import com.ggranados.sercretsanta.api.person.Person
import org.hibernate.annotations.Fetch
import javax.persistence.*

@Entity
@Table( name = "team")
data class Team(
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    val id: Long = 0,

    @Column
    val name: String = "",


    @OneToMany(
        fetch = FetchType.LAZY,
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    )
    @JoinColumn(
        name = "team_id",
        referencedColumnName = "id"
    )
    var members: MutableList<Person> = ArrayList<Person>()
) {

}
package com.ggranados.sercretsanta.api.event

import com.ggranados.sercretsanta.api.team.Team
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table( name= "event" )
data class Event (

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    val id: Long = 0,
    
    @Column( name = "title" )
    val title: String = "",

    @Column( name = "date" )
    val date: LocalDate = LocalDate.now(),

    @OneToMany(
        fetch = FetchType.LAZY,
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    )
    @JoinColumn(
        name = "event_id",
        referencedColumnName = "id"
    )
    var teams: MutableList<Team> = ArrayList<Team>()
) {
}
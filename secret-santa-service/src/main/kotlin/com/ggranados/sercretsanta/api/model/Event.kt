package com.ggranados.sercretsanta.api.model

import java.time.LocalDate
import javax.persistence.*

@Entity
@Table( name= "event" )
class Event (

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    val id: Long = 0,

    @Column( name = "title" )
    val title: String = "",

    @Column( name = "date" )
    val date: LocalDate = LocalDate.now(),

    @OneToMany(
        mappedBy = "event",
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    )
    val participants: List<Person> = ArrayList<Person>()
) {
}
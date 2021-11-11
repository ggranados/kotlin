package com.ggranados.sercretsanta.api.model

import javax.persistence.*

@Entity
@Table( name = "team")
class Team (
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    val id: Long = 0,

    @Column
    val name: String = "",

    @OneToMany(
        mappedBy = "team",
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    )
    val members: List<Person> = ArrayList<Person>()
) {
}
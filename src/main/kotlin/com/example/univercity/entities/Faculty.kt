package com.example.univercity.entities

import javax.persistence.Entity
import javax.persistence.ManyToOne


@Entity
class Fakultet(
    var name:String,
    @ManyToOne
    var univercity: Univercity
):BaseEntity()
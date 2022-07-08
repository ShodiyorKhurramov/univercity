package com.example.univercity.entities

import javax.persistence.Entity
import javax.persistence.ManyToOne


@Entity
class Group(
    var name:String,
    @ManyToOne
    var fakultet: Fakultet,
    var year:Long
):BaseEntity()
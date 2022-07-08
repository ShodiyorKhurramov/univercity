package com.example.univercity.entities

import javax.persistence.Entity
import javax.persistence.ManyToOne


@Entity
class Subject(
    var name:String,
    @ManyToOne
   var group: Group
):BaseEntity()
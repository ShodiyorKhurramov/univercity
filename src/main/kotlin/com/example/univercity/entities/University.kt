package com.example.univercity.entities

import javax.persistence.Entity

@Entity
class Univercity(
var name:String,
var address:String,
var openYear:Int


):BaseEntity()
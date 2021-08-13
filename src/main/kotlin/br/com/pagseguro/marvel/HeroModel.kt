package br.com.pagseguro.marvel

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class HeroModel(
    @Id @GeneratedValue val id: Int?,
    val name: String,
    val style: String,
    val power: String
)

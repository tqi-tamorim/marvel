package br.com.pagseguro.marvel.domain.dto

data class HeroDTO(
    val id: Long? = null,
    val name: String,
    val style: String,
    val powers: List<String>
)

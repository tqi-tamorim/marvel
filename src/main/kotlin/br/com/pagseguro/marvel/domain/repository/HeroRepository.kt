package br.com.pagseguro.marvel.domain.repository

import br.com.pagseguro.marvel.domain.model.Hero
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface HeroRepository : PagingAndSortingRepository<Hero, Long> {

    fun existsByName(name: String): Boolean

}

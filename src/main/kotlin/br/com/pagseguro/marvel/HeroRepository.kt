package br.com.pagseguro.marvel

import org.springframework.data.repository.CrudRepository

interface HeroRepository: CrudRepository<HeroModel, Int>{

}

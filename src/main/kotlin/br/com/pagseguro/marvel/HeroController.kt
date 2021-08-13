package br.com.pagseguro.marvel

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/hero")
class HeroController(
    @Autowired val repository: HeroRepository
) {

    @PostMapping
    fun createHero(): HeroModel {
        val hero = HeroModel(
            id = null,
            name = "Homem-aranha",
            style = "urbano",
            power = "Lançar teia"
        )
        return repository.save(hero)
    }

}

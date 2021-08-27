package br.com.pagseguro.marvel.controller

import br.com.pagseguro.marvel.domain.dto.HeroDTO
import br.com.pagseguro.marvel.domain.dto.ApiResponse
import br.com.pagseguro.marvel.service.HeroService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Api(tags = ["Heróis"])
@RestController
@RequestMapping("/hero")
class HeroController(
    val service: HeroService
) {

    @PostMapping
    @ApiOperation(value = "Inserção de um novo herói")
    fun createHero(@RequestBody dto: HeroDTO): ResponseEntity<ApiResponse> {
        return ResponseEntity.ok(service.save(dto))
    }

    @GetMapping
    @ApiOperation(value = "Listagem de todos os heróis de forma paginada")
    fun findAll(pageable: Pageable): ResponseEntity<Page<HeroDTO>> {
        return ResponseEntity.ok(service.findAll(pageable))
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Busca de herói por identificador")
    fun findById(@PathVariable id: Long): ResponseEntity<HeroDTO> {
        return ResponseEntity.ok(service.findById(id))
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Remove herói por identificador")
    fun deleteById(@PathVariable id: Long): ResponseEntity<ApiResponse> {
        return ResponseEntity.ok(service.deleteById(id))
    }

}

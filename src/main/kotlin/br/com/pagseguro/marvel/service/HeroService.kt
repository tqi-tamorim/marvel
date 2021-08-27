package br.com.pagseguro.marvel.service

import br.com.pagseguro.marvel.domain.dto.ApiResponse
import br.com.pagseguro.marvel.domain.dto.HeroDTO
import br.com.pagseguro.marvel.domain.mapper.HeroMapper
import br.com.pagseguro.marvel.domain.repository.HeroRepository
import br.com.pagseguro.marvel.exception.BusinessException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class HeroService {

    @Autowired
    private lateinit var heroRepository: HeroRepository

    @Autowired
    private lateinit var heroMapper: HeroMapper

    @Transactional
    fun save(dto: HeroDTO): ApiResponse {
        if (heroRepository.existsByName(dto.name)) {
            throw BusinessException("Herói já existe na base de dados")
        }
        return ApiResponse(
            "Herói salvo com sucesso",
            heroMapper.toDto(heroRepository.save(heroMapper.toEntity(dto)))
        )
    }

    fun findById(id: Long): HeroDTO {
        val hero = heroRepository.findById(id).orElseThrow { BusinessException("Herói não encontrado") }
        return heroMapper.toDto(hero)
    }

    fun findAll(pageable: Pageable): Page<HeroDTO> {
        return heroRepository.findAll(pageable).map(heroMapper::toDto)
    }

    @Transactional
    fun deleteById(id: Long): ApiResponse {
        if (!heroRepository.existsById(id)) {
            throw BusinessException("Herói não encontrado")
        }
        heroRepository.deleteById(id)
        return ApiResponse("Herói removido com sucesso")
    }
}
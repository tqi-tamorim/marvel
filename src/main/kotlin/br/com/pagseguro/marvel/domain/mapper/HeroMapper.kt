package br.com.pagseguro.marvel.domain.mapper

import br.com.pagseguro.marvel.domain.dto.HeroDTO
import br.com.pagseguro.marvel.domain.mapper.BaseMapper
import br.com.pagseguro.marvel.domain.model.Hero
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface HeroMapper : BaseMapper<Hero, HeroDTO> {

}
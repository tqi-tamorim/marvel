package br.com.pagseguro.marvel.domain.mapper

import org.mapstruct.InheritInverseConfiguration
import org.mapstruct.MappingTarget


interface BaseMapper<E, D> {
    fun toDto(entity: E): D
    fun toEntity(dto: D): E
    fun toDto(entities: List<E>): List<D>
    fun toDto(entities: Iterable<E>): List<D>
    fun toEntity(dtos: List<D>): List<E>

    @InheritInverseConfiguration(name = "toDto")
    fun fromDto(dto: D, @MappingTarget entity: E)
}

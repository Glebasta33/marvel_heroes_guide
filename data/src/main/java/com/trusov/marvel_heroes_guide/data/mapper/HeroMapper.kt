package com.trusov.marvel_heroes_guide.data.mapper

import com.trusov.marvel_heroes_guide.data.remote.model.HeroDto
import com.trusov.marvel_heroes_guide.domain.domain.entity.Hero
import javax.inject.Inject

class HeroMapper @Inject constructor() {
    fun mapDtoToDbModel(dto: HeroDto) = Hero(
        name = dto.name,
        imageUrl = "${dto.image.path}.${dto.image.extension}",
        id = dto.id
    )
}
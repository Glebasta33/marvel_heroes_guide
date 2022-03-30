package com.trusov.marvel_heroes_guide.list_feature.data.mapper

import com.trusov.marvel_heroes_guide.list_feature.data.remote.model.HeroDto
import com.trusov.marvel_heroes_guide.list_feature.data.remote.model.JsonResponseContainerDto
import com.trusov.marvel_heroes_guide.list_feature.domain.entity.Hero
import javax.inject.Inject

class HeroMapper @Inject constructor() {
    fun mapDtoToDbModel(dto: HeroDto) = Hero(
        name = dto.name,
        imageUrl = "${dto.image.path}.${dto.image.extension}",
        id = dto.id
    )
}
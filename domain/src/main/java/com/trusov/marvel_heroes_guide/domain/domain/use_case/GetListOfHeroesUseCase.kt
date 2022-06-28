package com.trusov.marvel_heroes_guide.domain.domain.use_case

import com.trusov.marvel_heroes_guide.domain.domain.entity.Hero
import com.trusov.marvel_heroes_guide.domain.domain.repository.MarvelRepository
import javax.inject.Inject

class GetListOfHeroesUseCase @Inject constructor(private val repo: MarvelRepository) {
    suspend operator fun invoke(): List<Hero> = repo.getListOfHeroes()
}
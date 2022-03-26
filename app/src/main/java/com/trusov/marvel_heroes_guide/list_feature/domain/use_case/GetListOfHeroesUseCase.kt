package com.trusov.marvel_heroes_guide.list_feature.domain.use_case

import androidx.lifecycle.LiveData
import com.trusov.marvel_heroes_guide.list_feature.domain.entity.Hero
import com.trusov.marvel_heroes_guide.list_feature.domain.repository.MarvelRepository
import javax.inject.Inject

class GetListOfHeroesUseCase @Inject constructor(private val repo: MarvelRepository) {
    suspend operator fun invoke(): LiveData<List<Hero>> = repo.getListOfHeroes()
}
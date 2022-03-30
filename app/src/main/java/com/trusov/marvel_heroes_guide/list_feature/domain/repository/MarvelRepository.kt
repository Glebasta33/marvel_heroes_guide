package com.trusov.marvel_heroes_guide.list_feature.domain.repository

import androidx.lifecycle.LiveData
import com.trusov.marvel_heroes_guide.list_feature.domain.entity.Hero

interface MarvelRepository {
    suspend fun getListOfHeroes(): List<Hero>
}
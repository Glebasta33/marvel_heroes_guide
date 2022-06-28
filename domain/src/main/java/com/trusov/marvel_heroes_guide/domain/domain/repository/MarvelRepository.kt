package com.trusov.marvel_heroes_guide.domain.domain.repository

import com.trusov.marvel_heroes_guide.domain.domain.entity.Hero

interface MarvelRepository {
    suspend fun getListOfHeroes(): List<Hero>
}
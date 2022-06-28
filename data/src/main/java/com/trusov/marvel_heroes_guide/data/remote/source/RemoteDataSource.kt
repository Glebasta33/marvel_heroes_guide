package com.trusov.marvel_heroes_guide.data.remote.source

import com.trusov.marvel_heroes_guide.domain.domain.entity.Hero

interface RemoteDataSource {
    suspend fun getListOfHeroes(): List<Hero>
}
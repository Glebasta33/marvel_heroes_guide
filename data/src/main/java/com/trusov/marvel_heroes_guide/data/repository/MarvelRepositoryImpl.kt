package com.trusov.marvel_heroes_guide.data.repository

import com.trusov.marvel_heroes_guide.data.remote.source.RemoteDataSource
import com.trusov.marvel_heroes_guide.domain.domain.entity.Hero
import com.trusov.marvel_heroes_guide.domain.domain.repository.MarvelRepository
import javax.inject.Inject

class MarvelRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : MarvelRepository {
    override suspend fun getListOfHeroes(): List<Hero> {
        return remoteDataSource.getListOfHeroes()
    }
}
package com.trusov.marvel_heroes_guide.list_feature.data.repository

import androidx.lifecycle.LiveData
import com.trusov.marvel_heroes_guide.list_feature.data.remote.source.RemoteDataSource
import com.trusov.marvel_heroes_guide.list_feature.domain.entity.Hero
import com.trusov.marvel_heroes_guide.list_feature.domain.repository.MarvelRepository
import javax.inject.Inject

class MarvelRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : MarvelRepository {
    override suspend fun getListOfHeroes(): List<Hero> {
        return remoteDataSource.getListOfHeroes()
    }
}
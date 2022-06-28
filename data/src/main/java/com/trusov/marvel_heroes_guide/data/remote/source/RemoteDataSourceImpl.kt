package com.trusov.marvel_heroes_guide.data.remote.source

import android.util.Log
import com.trusov.marvel_heroes_guide.data.mapper.HeroMapper
import com.trusov.marvel_heroes_guide.data.remote.retrofit.MarvelApiService
import com.trusov.marvel_heroes_guide.domain.domain.entity.Hero
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val mapper: HeroMapper,
    private val apiService: MarvelApiService
) : RemoteDataSource {
    override suspend fun getListOfHeroes(): List<Hero>{
        try {
            val ts = System.currentTimeMillis()
            val listOfHeroes = apiService.getListOfHeroes(ts = ts).data.heroes
            val result = listOfHeroes.map { mapper.mapDtoToDbModel(it) }
            Log.d("DataSourceImpl", result.toString())
            return result
        } catch (e: Exception) {
            Log.d("DataSourceImpl", e.localizedMessage)
        }
        return listOf(Hero("Ошибка при загрузке данных", "http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available.jpg", -1))
    }
}
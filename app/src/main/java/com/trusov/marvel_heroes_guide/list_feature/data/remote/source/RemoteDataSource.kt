package com.trusov.marvel_heroes_guide.list_feature.data.remote.source

import androidx.lifecycle.LiveData
import com.trusov.marvel_heroes_guide.list_feature.domain.entity.Hero

interface RemoteDataSource {
    suspend fun getListOfHeroes(): List<Hero>
}
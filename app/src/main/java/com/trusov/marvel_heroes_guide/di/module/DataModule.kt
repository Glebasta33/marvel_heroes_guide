package com.trusov.marvel_heroes_guide.di.module

import com.trusov.marvel_heroes_guide.list_feature.data.remote.retrofit.MarvelApiFactory
import com.trusov.marvel_heroes_guide.list_feature.data.remote.retrofit.MarvelApiService
import com.trusov.marvel_heroes_guide.list_feature.data.remote.source.RemoteDataSource
import com.trusov.marvel_heroes_guide.list_feature.data.remote.source.RemoteDataSourceImpl
import com.trusov.marvel_heroes_guide.list_feature.data.repository.MarvelRepositoryImpl
import com.trusov.marvel_heroes_guide.list_feature.domain.repository.MarvelRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {
    @Binds
    fun bindMarvelRepository(impl: MarvelRepositoryImpl): MarvelRepository
    @Binds
    fun bindRemoteDataSource(impl: RemoteDataSourceImpl): RemoteDataSource
    companion object {
        @Provides
        fun provideApiService(): MarvelApiService {
            return MarvelApiFactory.apiService
        }
    }
}
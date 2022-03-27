package com.trusov.marvel_heroes_guide.list_feature.data.remote.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MarvelApiFactory {
    private const val BASE_URL = "https://gateway.marvel.com/v1/"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    val apiService = retrofit.create(MarvelApiService::class.java)
}
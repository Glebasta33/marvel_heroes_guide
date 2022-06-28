package com.trusov.marvel_heroes_guide.data.remote.retrofit

import android.util.Log
import com.trusov.marvel_heroes_guide.data.remote.model.JsonResponseContainerDto
import retrofit2.http.GET
import retrofit2.http.Query
import java.math.BigInteger
import java.security.MessageDigest

interface MarvelApiService {
    @GET("public/characters")
    suspend fun getListOfHeroes(
        @Query(QUERY_PARAM_API_KEY) apiKey: String = "9990f3313550ec7d564085cf08148b0b",
        @Query(QUERY_PARAM_LIMIT) limit: Int = 50,
        @Query(QUERY_PARAM_ORDER_BY) orderBy: String = QUERY_PARAM_NAME,
        @Query(QUERY_PARAM_TIMESTAMP) ts: Long,
        @Query(QUERY_PARAM_HASH) hash: String = getHash(ts)
    ): JsonResponseContainerDto



    companion object {
        private const val QUERY_PARAM_API_KEY = "apikey"
        private const val QUERY_PARAM_LIMIT = "limit"
        private const val QUERY_PARAM_ORDER_BY = "orderBy"
        private const val QUERY_PARAM_TIMESTAMP = "ts"
        private const val QUERY_PARAM_HASH = "hash"

        fun getHash(ts: Long): String {
            val md = MessageDigest.getInstance("MD5")
            val privateKey = "ebb5ef93f0a2711e0f7359887e6a6c72587f5038"
            val publicKey = "9990f3313550ec7d564085cf08148b0b"
            val input = "$ts$privateKey$publicKey"
            val hash = BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
            Log.d("MarvelApiService", "ts $ts, hash $hash")
            return hash
        }

        private const val QUERY_PARAM_NAME = "name"
    }
}
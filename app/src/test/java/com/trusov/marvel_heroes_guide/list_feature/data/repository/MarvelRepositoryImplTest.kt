package com.trusov.marvel_heroes_guide.list_feature.data.repository

import android.util.Log
import com.trusov.marvel_heroes_guide.list_feature.data.remote.retrofit.MarvelApiFactory
import com.trusov.marvel_heroes_guide.list_feature.data.remote.retrofit.MarvelApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import org.junit.After
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test


class MarvelRepositoryImplTest {

    private lateinit var service: MarvelApiService
    private lateinit var coroutineScope: CoroutineScope
    private var ts: Long = 0L

    @Before
    fun setUp() {
        service = MarvelApiFactory.apiService
        coroutineScope = CoroutineScope(Dispatchers.Default)
        ts = System.currentTimeMillis()
    }

    @Test
    fun statusIsOk() {
        coroutineScope.launch {
            val expected = "Ok"
            val actual = service.getListOfHeroes(limit = 3, ts = ts).status
            assertEquals(expected, actual)
        }
    }

    @Test
    fun whenLimit3Size3() {
        coroutineScope.launch {
            val expected = 3
            val actual = service.getListOfHeroes(limit = 3, ts = ts).data.count
            assertEquals(expected, actual)
        }
    }

    @After
    fun close() {
        coroutineScope.cancel()
    }
}
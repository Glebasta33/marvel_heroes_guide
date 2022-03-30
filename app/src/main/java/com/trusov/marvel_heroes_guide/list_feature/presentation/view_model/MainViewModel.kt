package com.trusov.marvel_heroes_guide.list_feature.presentation.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trusov.marvel_heroes_guide.list_feature.domain.entity.Hero
import com.trusov.marvel_heroes_guide.list_feature.domain.use_case.GetListOfHeroesUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getListOfHeroesUseCase: GetListOfHeroesUseCase
) : ViewModel() {

    private val _heroes = MutableLiveData<List<Hero>>()
    val heroes: LiveData<List<Hero>> = _heroes

    fun getListOfHeroes() {
        viewModelScope.launch {
            _heroes.postValue(getListOfHeroesUseCase())
        }
    }

}
package com.trusov.marvel_heroes_guide.di.module

import androidx.lifecycle.ViewModel
import com.trusov.marvel_heroes_guide.di.annotation.ViewModelKey
import com.trusov.marvel_heroes_guide.list_feature.presentation.view_model.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    @Binds
    fun bindsCoinViewModel(impl: MainViewModel): ViewModel
}
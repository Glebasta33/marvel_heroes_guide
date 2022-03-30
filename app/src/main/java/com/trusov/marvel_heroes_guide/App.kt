package com.trusov.marvel_heroes_guide

import android.app.Application
import com.trusov.marvel_heroes_guide.di.component.DaggerApplicationComponent

class App : Application() {
    val component by lazy {
        DaggerApplicationComponent.factory()
            .create(this)
    }
}
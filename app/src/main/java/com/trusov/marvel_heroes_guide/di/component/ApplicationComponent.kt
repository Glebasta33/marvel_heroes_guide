package com.trusov.marvel_heroes_guide.di.component

import android.app.Application
import com.trusov.marvel_heroes_guide.App
import com.trusov.marvel_heroes_guide.di.module.DataModule
import com.trusov.marvel_heroes_guide.di.module.ViewModelModule
import com.trusov.marvel_heroes_guide.list_feature.presentation.activity.MainActivity
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        DataModule::class,
        ViewModelModule::class
    ]
)
interface ApplicationComponent {

    fun inject(instance: App)
    fun inject(instance: MainActivity)

    @Component.Factory
    interface ApplicationComponentFactory {
        fun create(
            @BindsInstance
            application: Application
        ): ApplicationComponent
    }
}
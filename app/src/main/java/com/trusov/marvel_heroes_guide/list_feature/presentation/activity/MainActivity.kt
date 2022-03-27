package com.trusov.marvel_heroes_guide.list_feature.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.trusov.marvel_heroes_guide.App
import com.trusov.marvel_heroes_guide.R
import com.trusov.marvel_heroes_guide.list_feature.domain.use_case.GetListOfHeroesUseCase
import com.trusov.marvel_heroes_guide.list_feature.presentation.view_model.MainViewModel
import com.trusov.marvel_heroes_guide.list_feature.presentation.view_model.ViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: MainViewModel
    private lateinit var scope: CoroutineScope

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as App).component.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        scope = CoroutineScope(Dispatchers.Main)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
        viewModel.getListOfHeroes()
        viewModel.heroes.observe(this) {
            for (hero in it) {
                Log.d("MainActivityTag", hero.toString())
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
    }
}
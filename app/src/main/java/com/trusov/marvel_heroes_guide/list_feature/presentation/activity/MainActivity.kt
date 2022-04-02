package com.trusov.marvel_heroes_guide.list_feature.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.trusov.marvel_heroes_guide.App
import com.trusov.marvel_heroes_guide.R
import com.trusov.marvel_heroes_guide.databinding.ActivityMainBinding
import com.trusov.marvel_heroes_guide.list_feature.presentation.adapter.HeroAdapter
import com.trusov.marvel_heroes_guide.list_feature.presentation.view_model.MainViewModel
import com.trusov.marvel_heroes_guide.list_feature.presentation.view_model.ViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: MainViewModel
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as App).component.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val heroAdapter = HeroAdapter(application)
        binding.rvHeroes.adapter = heroAdapter
        heroAdapter.onHeroClickListener = {
            Toast.makeText(this, "$it", Toast.LENGTH_SHORT).show()
        }
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
        viewModel.getListOfHeroes()
        viewModel.heroes.observe(this) {
            Log.d("MainActivityTag", it.toString())
            heroAdapter.submitList(it)
        }
    }
}
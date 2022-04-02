package com.trusov.marvel_heroes_guide.list_feature.presentation.adapter

import android.annotation.SuppressLint
import android.app.Application
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.trusov.marvel_heroes_guide.R
import com.trusov.marvel_heroes_guide.list_feature.domain.entity.Hero
import javax.inject.Inject

class HeroAdapter(
    private val application: Application
) : ListAdapter<Hero, HeroViewHolder>(HeroDiffCallback()) {

    var onHeroClickListener: ((Hero) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.hero_layout, parent, false)
        return HeroViewHolder(view)
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        val hero = currentList[position]
        with(holder.binding) {
            tvName.text = hero.name
            Picasso.get().load(hero.imageUrl)
                .error(R.drawable.ic_launcher_background)
                .placeholder(R.drawable.hero_placeholder)
                .into(ivImage, object : Callback {
                    @SuppressLint("UseCompatLoadingForDrawables")
                    override fun onSuccess() {
                        if (hero.imageUrl == "http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available.jpg") {
                            val placeholder = application.resources
                                .getDrawable(R.drawable.hero_placeholder, null)
                            ivImage.setImageDrawable(placeholder)
                        }
                    }

                    override fun onError(e: Exception?) {
                        e?.printStackTrace()
                    }

                })
            root.setOnClickListener {
                onHeroClickListener?.invoke(hero)
            }
        }
    }
}
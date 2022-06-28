package com.trusov.marvel_heroes_guide.list_feature.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.trusov.marvel_heroes_guide.domain.domain.entity.Hero

class HeroDiffCallback : DiffUtil.ItemCallback<Hero>() {
    override fun areItemsTheSame(oldItem: Hero, newItem: Hero): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Hero, newItem: Hero): Boolean {
        return oldItem == newItem
    }
}
package com.trusov.marvel_heroes_guide.list_feature.data.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class HeroDto(
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("name")
    @Expose
    val name: String,
    @SerializedName("thumbnail")
    @Expose
    val image: ImageDto
)
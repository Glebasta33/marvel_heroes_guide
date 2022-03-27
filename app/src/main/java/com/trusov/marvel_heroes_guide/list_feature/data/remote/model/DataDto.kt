package com.trusov.marvel_heroes_guide.list_feature.data.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DataDto(
    @SerializedName("count")
    @Expose
    val count: Int,
    @SerializedName("limit")
    @Expose
    val limit: Int,
    @SerializedName("offset")
    @Expose
    val offset: Int,
    @SerializedName("results")
    @Expose
    val heroes: List<HeroDto>,
    @SerializedName("total")
    @Expose
    val total: Int
)
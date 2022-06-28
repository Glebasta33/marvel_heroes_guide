package com.trusov.marvel_heroes_guide.data.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ImageDto(
    @SerializedName("extension")
    @Expose
    val extension: String,
    @SerializedName("path")
    @Expose
    val path: String
)
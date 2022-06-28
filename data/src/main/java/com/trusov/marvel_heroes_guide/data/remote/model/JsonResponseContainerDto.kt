package com.trusov.marvel_heroes_guide.data.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class JsonResponseContainerDto(
    @SerializedName("data")
    @Expose
    val data: DataDto,
    @SerializedName("status")
    @Expose
    val status: String
)
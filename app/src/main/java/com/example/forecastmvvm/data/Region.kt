package com.example.forecastmvvm.data


import com.google.gson.annotations.SerializedName

data class Region(
    @SerializedName("ciudad")
    val ciudad: String,
    @SerializedName("estado")
    val estado: String
)
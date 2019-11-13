package com.example.forecastmvvm.data


import com.google.gson.annotations.SerializedName

data class EmpleosResponse(
    @SerializedName("descripcion")
    val descripcion: String,
    @SerializedName("empleo")
    val empleo: String,
    @SerializedName("fecha")
    val fecha: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("imagen")
    val imagen: String,
    @SerializedName("moneda")
    val moneda: String,
    @SerializedName("region")
    val region: Region,
    @SerializedName("salario")
    val salario: String,
    @SerializedName("signo")
    val signo: String,
    @SerializedName("unidad_temporal")
    val unidadTemporal: String
)
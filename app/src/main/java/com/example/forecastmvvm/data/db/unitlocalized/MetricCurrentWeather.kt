package com.example.forecastmvvm.data.db.unitlocalized

import androidx.room.ColumnInfo

data class MetricCurrentWeather(
    @ColumnInfo(name="temperature")
    override val temperature: Int,
    @ColumnInfo(name="feelslike")
    override val feelsLikeTemperature: Int,
    @ColumnInfo(name="visibility")
    override val visibilityDistance: Int,
    @ColumnInfo(name="precip")
    override val precipitationVolume: Double,
    @ColumnInfo(name="windDir")
    override val windDirection: String,
    @ColumnInfo(name="windSpeed")
    override val windSpeed: Int
) : UnitCurrentWeather
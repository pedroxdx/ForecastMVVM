package com.example.forecastmvvm.data.db.unitlocalized

interface UnitCurrentWeather {
    val temperature: Int
    val feelsLikeTemperature: Int
    val visibilityDistance: Int
    val precipitationVolume: Double
    val windDirection: String
    val windSpeed: Int
}
package com.example.forecastmvvm.data.db.entity


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

const val CURRENT_WEATHER_ID = 0

@Entity(tableName = "current_weather")
data class Current(
    @SerializedName("feelslike")
    val feelslike: Int,
    @SerializedName("humidity")
    val humidity: Int,
    @SerializedName("is_day")
    val isDay: String,
    @SerializedName("precip")
    val precip: Double,
    @SerializedName("pressure")
    val pressure: Int,
    @SerializedName("temperature")
    val temperature: Int,
    @SerializedName("visibility")
    val visibility: Int,
    @SerializedName("wind_degree")
    val windDegree: Int,
    @SerializedName("wind_dir")
    val windDir: String,
    @SerializedName("wind_speed")
    val windSpeed: Int
){
    @PrimaryKey(autoGenerate = false)
    var id: Int = CURRENT_WEATHER_ID
}
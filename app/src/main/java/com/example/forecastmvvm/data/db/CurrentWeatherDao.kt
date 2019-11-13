package com.example.forecastmvvm.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.forecastmvvm.data.db.entity.CURRENT_WEATHER_ID
import com.example.forecastmvvm.data.db.entity.Current
import com.example.forecastmvvm.data.db.unitlocalized.MetricCurrentWeather

@Dao
interface CurrentWeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(currentEntry: Current)

    @Query("select * from current_weather where id = ${CURRENT_WEATHER_ID}")
    fun getWeatherMetric(): LiveData<MetricCurrentWeather>
}
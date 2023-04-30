package com.betulnecanli.weatherapp.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "weather_response")
data class WeatherResponse(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 1,
    @Embedded
    val current_weather: CurrentWeather,
    @Embedded
    val daily: Daily
)

@Entity
data class CurrentWeather(
    @PrimaryKey
    val id2: Int = 1,
    val is_day: Int,
    val temperature: Double

)

@Entity
data class Daily(
    @PrimaryKey
    val id3: Int = 1,
    @SerializedName("apparent_temperature_max")
    val apparent_temperature_max: List<Double>,
    @SerializedName("apparent_temperature_min")
    val apparent_temperature_min: List<Double>,
    @SerializedName("time")
    val time: List<String>

)

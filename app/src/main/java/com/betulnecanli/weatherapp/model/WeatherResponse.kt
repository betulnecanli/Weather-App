package com.betulnecanli.weatherapp.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "weather_response")
data class WeatherResponse(
    @PrimaryKey
    val id: Int = 1, // we need a primary key since Room requires each entity to have one
    @Embedded
    val current_weather: CurrentWeather,
    @Embedded
    val daily: Daily,
    @Embedded
    val daily_units: DailyUnits,
    val elevation: Double,
    val generationtime_ms: Double,
    val latitude: Double,
    val longitude: Double,
    val timezone: String,
    val timezone_abbreviation: String,
    val utc_offset_seconds: Int
)

@Entity
data class CurrentWeather(
    @PrimaryKey
    val id2: Int = 1,
    val is_day: Int,
    val temperature: Double,
    @SerializedName("time")
    val time1: String,
    @SerializedName("weathercode")
    val weathercode: Int,
    val winddirection: Double,
    val windspeed: Double
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
    val time2: List<String>,
    @SerializedName("weathercode")
    val weathercode2: List<Int>
)
@Entity
data class DailyUnits(
    @PrimaryKey
    val id4: Int = 1,
    @SerializedName("apparent_temperature_max")
    val apparent_temperature_max2: String,
    @SerializedName("apparent_temperature_min")
    val apparent_temperature_min2: String,
    @SerializedName("time")
    val time: String,
    @SerializedName("weathercode")
    val weathercode3: String
)
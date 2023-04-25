package com.betulnecanli.weatherapp.network

import com.betulnecanli.weatherapp.model.WeatherResponse
import com.betulnecanli.weatherapp.util.Constants
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("v1/forecast")
    fun getWeatherResult(
        @Query("latitude") latitude: Double = 25.772915,
        @Query("longitude") longitude: Double = -80.1983,
        @Query("current_weather") currentWeather: Boolean = true,
        @Query("daily") daily: String = "weathercode,apparent_temperature_max,apparent_temperature_min",
        @Query("timezone") timezone: String = "auto",
        @Query("temperature_unit") temperatureUnit: String = "celsius",
        @Query("forecast_days") forecastDays: Int = 14
    ) : Call<WeatherResponse>

    companion object{

        fun create() : WeatherService {

            val retrofit = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(WeatherService::class.java)
        }


    }
}
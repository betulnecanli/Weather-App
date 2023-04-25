package com.betulnecanli.weatherapp.network

import com.betulnecanli.weatherapp.model.WeatherResponse
import com.betulnecanli.weatherapp.util.Constants
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface WeatherService {
    @GET("v1/forecast?latitude=40.7750&longitude=29.9480&current_weather=true&daily=weathercode,apparent_temperature_max,apparent_temperature_min&timezone=auto&temperature_unit=celsius&forecast_days=14")
    fun getWeatherResult() : Call<WeatherResponse>

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
package com.betulnecanli.weatherapp.repository

import android.content.Context
import com.betulnecanli.weatherapp.data.local.WeatherDB
import com.betulnecanli.weatherapp.model.WeatherResponse
import com.betulnecanli.weatherapp.network.WeatherService
import com.betulnecanli.weatherapp.util.CheckInternet
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import kotlinx.coroutines.Dispatchers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherRepository(
    private val context : Context,
    private val weatherService: WeatherService,
    private val weatherDb: WeatherDB
) {

    suspend fun getDataFromService(callback: (WeatherResponse?) -> Unit)  {

            if (CheckInternet.isInternetAvailable(context)){
                withContext(Dispatchers.IO){
                    val response = weatherService.getWeatherResult().body()
                    weatherDb.weatherDao().deleteAll()
                    if (response != null) {
                        weatherDb.weatherDao().insert(response)
                    }

                    val weatherList = weatherDb.weatherDao().getAll()
                    callback(weatherList)
                }
            }
            else{
                withContext(Dispatchers.IO){
                    val weatherList = weatherDb.weatherDao().getAll()
                    callback(weatherList)
                }


            }

    }
}
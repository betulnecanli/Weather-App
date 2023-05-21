package com.betulnecanli.weatherapp.repository

import android.content.Context
import com.betulnecanli.weatherapp.data.local.WeatherDB
import com.betulnecanli.weatherapp.model.WeatherResponse
import com.betulnecanli.weatherapp.network.WeatherService
import com.betulnecanli.weatherapp.util.CheckInternet
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherRepository(
    private val context : Context,
    private val weatherService: WeatherService,
    private val weatherDb: WeatherDB
) {

    fun getDataFromService() : Flow<WeatherResponse> = flow{
        if (CheckInternet.isInternetAvailable(context)){
            val response = weatherService.getWeatherResult()
            weatherDb.weatherDao().deleteAll()
            weatherDb.weatherDao().insert(response)
            val weatherList = weatherDb.weatherDao().getAll()
            emit(weatherList)
        }
        else{
            val weatherList = weatherDb.weatherDao().getAll()
            emit(weatherList)
        }

    }.flowOn(Dispatchers.IO)

   /* suspend fun getDataFromService(callback: (WeatherResponse) -> Unit)  {

            if (CheckInternet.isInternetAvailable(context)){
                withContext(Dispatchers.IO){
                    val response = weatherService.getWeatherResult()
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


            }}*/


}
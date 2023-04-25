package com.betulnecanli.weatherapp.ui.Home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.betulnecanli.weatherapp.model.Daily
import com.betulnecanli.weatherapp.model.WeatherResponse
import com.betulnecanli.weatherapp.network.WeatherService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.DateFormat
import java.util.*

class HomeViewModel : ViewModel() {
    private val weatherService = WeatherService.create()

    private val _weatherData = MutableLiveData<WeatherResponse?>()
    val weatherData: LiveData<WeatherResponse?> = _weatherData


    fun getDataFromService() {
        weatherService.getWeatherResult().enqueue(object : Callback<WeatherResponse> {
            override fun onResponse(
                call: Call<WeatherResponse>,
                weatherResponse: Response<WeatherResponse>
            ) {
                if (weatherResponse.isSuccessful) {
                    val weatherResponse = weatherResponse.body()
                    _weatherData.value = weatherResponse
                    Log.d("wertyuı", weatherResponse.toString())
                }

            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {

            }
        })

    }

    fun setDates(daily: Daily?) {

        val date = Date()
        val calendar = Calendar.getInstance()
        calendar.time=date
        val format = DateFormat.getDateInstance(DateFormat.MEDIUM)
        val formatTitle = DateFormat.getDateInstance(DateFormat.FULL)

        val dates = daily?.time?.toMutableList()
        for (day in 0 until dates?.size!!) {
            if (day == 0) {
                val currentData = formatTitle.format(calendar.time)
                dates[day] = currentData
                calendar.add(Calendar.DATE, 1)
            } else {
                val currentData = format.format(calendar.time)
                dates[day] = currentData
                calendar.add(Calendar.DATE, 1)
            }
        }

    }


}
package com.betulnecanli.weatherapp.ui.Home

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.betulnecanli.weatherapp.data.local.WeatherDB
import com.betulnecanli.weatherapp.model.Daily
import com.betulnecanli.weatherapp.model.WeatherResponse
import com.betulnecanli.weatherapp.network.WeatherService
import com.betulnecanli.weatherapp.repository.WeatherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.DateFormat
import java.util.*

class HomeViewModel(private val weatherRepository: WeatherRepository) : ViewModel() {


    val weatherData: LiveData<WeatherResponse?> = weatherRepository.getDataFromService().asLiveData()


}
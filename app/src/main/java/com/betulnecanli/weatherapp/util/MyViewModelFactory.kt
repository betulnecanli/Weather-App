package com.betulnecanli.weatherapp.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.betulnecanli.weatherapp.repository.WeatherRepository
import com.betulnecanli.weatherapp.ui.Home.HomeViewModel

class MyViewModelFactory constructor(private val weatherRepository: WeatherRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeViewModel(weatherRepository) as T }}

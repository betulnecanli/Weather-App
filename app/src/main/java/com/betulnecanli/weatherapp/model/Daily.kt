package com.betulnecanli.weatherapp.model

data class Daily(
    val apparent_temperature_max: List<Double>,
    val apparent_temperature_min: List<Double>,
    val time: List<String>,
    val weathercode: List<Int>
)
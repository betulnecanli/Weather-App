package com.betulnecanli.weatherapp.util

import androidx.room.TypeConverter
import com.betulnecanli.weatherapp.model.CurrentWeather
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DatabaseConverter {
    private val gson = Gson()

    @TypeConverter
    fun fromStringtoListDouble(value: String): List<Double?> {
        val listType = object : TypeToken<List<Double?>>() {}.type
        return gson.fromJson(value, listType)
    }

    @TypeConverter
    fun fromDoubleList(list: List<Double?>): String {
        return gson.toJson(list)
    }


    @TypeConverter
    fun fromStringtoListString(value: String): List<String?> {
        val listType = object : TypeToken<List<String?>>() {}.type
        return gson.fromJson(value, listType)
    }

    @TypeConverter
    fun fromListString(list: List<String?>): String {
        return gson.toJson(list)
    }



}
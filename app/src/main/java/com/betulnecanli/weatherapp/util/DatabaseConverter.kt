package com.betulnecanli.weatherapp.util

import androidx.room.TypeConverter
import com.betulnecanli.weatherapp.model.CurrentWeather
import com.betulnecanli.weatherapp.model.Daily
import com.betulnecanli.weatherapp.model.DailyUnits
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DatabaseConverter {
    @TypeConverter
    fun fromString(value: String): CurrentWeather {
        return Gson().fromJson(value, CurrentWeather::class.java)
    }

    @TypeConverter
    fun fromCurrentWeather(weather: CurrentWeather): String {
        return Gson().toJson(weather)
    }
    @TypeConverter
    fun fromStringtoDaily(value: String): Daily {
        return Gson().fromJson(value, Daily::class.java)
    }

    @TypeConverter
    fun fromDaily(weather: Daily): String {
        return Gson().toJson(weather)
    }


    @TypeConverter
    fun fromStringtoDailyUnits(value: String): DailyUnits {
        return Gson().fromJson(value, DailyUnits::class.java)
    }

    @TypeConverter
    fun fromDaily(weather: DailyUnits): String {
        return Gson().toJson(weather)
    }

    @TypeConverter
    fun fromStringtoArraylistInt(value: String): ArrayList<Int> {
        return Gson().fromJson(value, object : TypeToken<ArrayList<Int>>() {}.type)
    }

    @TypeConverter
    fun fromArrayList(list: ArrayList<Int>): String {
        return Gson().toJson(list)
    }


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

    @TypeConverter
    fun fromStringtoListInt(value: String): List<Int?> {
        val listType = object : TypeToken<List<Int?>>() {}.type
        return gson.fromJson(value, listType)
    }

    @TypeConverter
    fun fromListInt(list: List<Int?>): String {
        return gson.toJson(list)
    }


}
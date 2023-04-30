package com.betulnecanli.weatherapp.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.betulnecanli.weatherapp.model.WeatherResponse

@Dao
interface WeatherDao {
    @Query("SELECT * FROM weather_response")
    fun getAll(): WeatherResponse

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(weatherResponse: WeatherResponse)

    @Query("DELETE FROM weather_response")
    fun deleteAll()
}
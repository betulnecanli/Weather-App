package com.betulnecanli.weatherapp.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.betulnecanli.weatherapp.model.WeatherResponse

@Dao
interface WeatherDao {
    @Query("SELECT * FROM weather_response")
    suspend fun getAll(): WeatherResponse

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(weatherResponse: WeatherResponse)

    @Query("DELETE FROM weather_response")
    suspend fun deleteAll()
}
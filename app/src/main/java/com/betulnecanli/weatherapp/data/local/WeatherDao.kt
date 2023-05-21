package com.betulnecanli.weatherapp.data.local

import androidx.room.*
import com.betulnecanli.weatherapp.model.WeatherResponse
import kotlinx.coroutines.flow.Flow

@Dao
interface WeatherDao {
    @Query("SELECT * FROM weather_response")
    suspend fun getAll(): WeatherResponse

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     suspend fun insert(weatherResponse: WeatherResponse)

     @Query("DELETE FROM weather_response")
     suspend fun deleteAll()
}

/*

Mantık
	•	Hava durumu uygulamasında “Thread” kullanılarak yapılan multi-threading kaldırılmalı. Onun yerine Coroutine kullanarak güncellenmeli.
	•	ViewModelScope kullandığınıza emin olun.
	•	API ve database işlemlerinin Dispacther.IO-da çalıştığına emin olun.
	•	LiveData-ya bir değer atayacağınız zaman, Main Thread-e donun ve orda yeni değer atayın. LiveData-yı background Thread-de güncellemeyin.

 */
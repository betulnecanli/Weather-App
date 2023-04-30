package com.betulnecanli.weatherapp.ui.Home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.betulnecanli.weatherapp.R
import com.betulnecanli.weatherapp.databinding.ItemCurrentWeatherBinding
import com.betulnecanli.weatherapp.databinding.ItemNextWeatherBinding
import com.betulnecanli.weatherapp.model.WeatherResponse
import com.betulnecanli.weatherapp.util.Constants

class HomeAdapter(weatherResponse: WeatherResponse):
    RecyclerView.Adapter<HomeAdapter.WeatherViewHolder>() {

    private val currentWeather = weatherResponse.current_weather
    private val dates = weatherResponse.daily.time
    private val minTem = weatherResponse.daily.apparent_temperature_min
    private val maxTem = weatherResponse.daily.apparent_temperature_max

    inner class WeatherViewHolder(itemView : View): ViewHolder(itemView){
            fun bind(time : String,
                     minTemp : Double,
                     maxTemp : Double
            ){

                if (adapterPosition == Constants.CURRENT_DAY) {
                    val binding = ItemCurrentWeatherBinding.bind(itemView)
                    binding.apply {
                        currentWeatherTV.text = currentWeather.temperature.toString().plus("C")
                    }
                }
                else{
                    val binding = ItemNextWeatherBinding.bind(itemView)
                    binding.apply {
                        dateTV.text = time.toString()
                        minTempTV.text=minTemp.toString()
                        maxTempTV.text = maxTemp.toString()
                    }
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view : View = when (viewType) {
            Constants.CURRENT_DAY -> layoutInflater.inflate(
                R.layout.item_current_weather,
                parent,
                false
            )
            Constants.NEXT_DAYS -> layoutInflater.inflate(
                R.layout.item_next_weather,
                parent,
                false
            )
            else -> throw IllegalArgumentException()
        }
        return WeatherViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dates.size ?: 0
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
       holder.bind(
           time = dates[position],
           maxTemp = maxTem[position],
           minTemp = minTem[position]

       )
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            Constants.CURRENT_DAY
        } else
            Constants.NEXT_DAYS
    }
}
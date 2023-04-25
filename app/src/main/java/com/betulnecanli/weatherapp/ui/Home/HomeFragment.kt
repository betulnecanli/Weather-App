package com.betulnecanli.weatherapp.ui.Home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.betulnecanli.weatherapp.R
import com.betulnecanli.weatherapp.databinding.FragmentHomeBinding
import com.betulnecanli.weatherapp.model.WeatherResponse

class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding
    private val viewModel : HomeViewModel by viewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)

        viewModel.getDataFromService()

        initObserve()


        return binding.root
    }

    fun initObserve(){
        viewModel.weatherData.observe(viewLifecycleOwner){
            initRecyclerView(it)

        }
    }


    fun initRecyclerView(weatherResponse: WeatherResponse?){
        val adapter = weatherResponse?.let { HomeAdapter(it) }
        binding.weatherRV.adapter= adapter
        binding.weatherRV.apply {
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
        }

    }

}
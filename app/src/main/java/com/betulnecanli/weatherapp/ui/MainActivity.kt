package com.betulnecanli.weatherapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.betulnecanli.weatherapp.R
import com.betulnecanli.weatherapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.testButton.setOnClickListener {
            throw RuntimeException("Test Crash") // Force a crash
        }

    }
}
package com.betulnecanli.weatherapp.util

import android.content.Context
import android.net.ConnectivityManager

object CheckInternet {
    fun isInternetAvailable(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (connectivityManager != null) {
            val networkInfo = connectivityManager.activeNetworkInfo
            if (networkInfo != null) {
                return networkInfo.isConnected
            }
        }
        return false
    }
}
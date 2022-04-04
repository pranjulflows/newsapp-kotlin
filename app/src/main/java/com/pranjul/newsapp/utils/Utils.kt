package com.pranjul.newsapp.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.pranjul.newsapp.app.AppClass


object Utils {
    fun getConnectionType(context: Context = AppClass.instance): Int {
        var result = 0 // Returns connection type. 0: none; 1: mobile data; 2: wifi; 3: vpn
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        cm?.run {
            cm.getNetworkCapabilities(cm.activeNetwork)?.run {
                when {
                    hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> result = 1
                    hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> result = 2
                    hasTransport(NetworkCapabilities.TRANSPORT_VPN) -> result = 3
                }
            }
        }
        return result
    }
}
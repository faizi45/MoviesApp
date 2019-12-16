package com.project.faizan.moviesgithub.data

import android.content.Context
import android.net.ConnectivityManager
import com.project.faizan.moviesgithub.internals.ApiException
import okhttp3.Interceptor
import okhttp3.Response

class ConnectivityInterceptorImpl(context: Context) : ConnectivityInterceptor {


    private val appContext = context.applicationContext

    override fun intercept(chain: Interceptor.Chain): Response {
        if (!isOnline())
            throw ApiException("No Internet", -99)
        else
            return chain.proceed(chain.request())
    }


    private fun isOnline(): Boolean {
        //we use this method to check if user is connected to network
        //and then fetch data from online or offline storage on this decision

        val connectivityManager = appContext.getSystemService(Context.CONNECTIVITY_SERVICE)
                as ConnectivityManager

        val networkInfo = connectivityManager.activeNetworkInfo

        return networkInfo != null && networkInfo.isConnected
    }
}
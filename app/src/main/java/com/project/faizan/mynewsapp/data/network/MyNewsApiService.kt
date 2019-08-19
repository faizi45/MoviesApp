package com.project.faizan.mynewsapp.data.network

import android.util.Log
import com.project.faizan.mynewsapp.data.ConnectivityInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.net.ssl.HttpsURLConnection

interface MyNewsApiService {

    /**
    This is a sample post request.

    @POST("login/registerDevice")
    fun registerDeiceApi(
    @Header("app") app: String,
    @Header("deviceId") deviceId: String
    ): LiveData<ApiResponse<RegisterDeviceResponseDto>>
     **/


    companion object {

        operator fun invoke(
            connectivityInterceptor: ConnectivityInterceptor
        ): MyNewsApiService {

            val requestInterceptorChain = Interceptor { chain ->

                val url = chain.request()
                    .url()
                    .newBuilder()
                    .build()

                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()

                Log.d("RAW_URL", url.toString())

                return@Interceptor chain.proceed(request)
            }

            val hv = HttpsURLConnection.getDefaultHostnameVerifier()
            val builder = OkHttpClient.Builder()
            builder.hostnameVerifier { hostname, session ->
                HttpsURLConnection.getDefaultHostnameVerifier().run {

                    verify("api.com/v1", session)
                }
            }

            val okHttpClient = builder
                .addInterceptor(requestInterceptorChain)
                .addInterceptor(connectivityInterceptor)
                .build()

            //todo change url here
            return Retrofit.Builder()
                .client(okHttpClient)
//                .baseUrl("https://api.com/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(LiveDataCallAdapterFactory())
                .build()
                .create(MyNewsApiService::class.java)


        }
    }
}
package com.example.forecastmvvm.data

import android.util.Base64
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "http://192.168.1.141/empleoreact/api/public/api/"

private val AUTH = "Basic "+ Base64.encodeToString("info@meridahammocks.com:Cc9240440".toByteArray(), Base64.NO_WRAP)

interface EmpleosApiService {

    @GET(value="empleos")
    fun getEmpleos(): Deferred<List<EmpleosResponse>>

    @GET(value="list")
    fun getEmpleosList(): Call<List<EmpleosListResponse>>

    companion object {
        operator fun invoke(): EmpleosApiService {

            val requestAuthInterceptor = Interceptor { chain ->

                val original = chain.request()

                val requestBuilder = original.newBuilder()
                    .addHeader("Authorization", AUTH)
                    .method(original.method(), original.body())
                    .build()

                return@Interceptor chain.proceed(requestBuilder)
            }

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestAuthInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(EmpleosApiService::class.java)
        }
    }
}
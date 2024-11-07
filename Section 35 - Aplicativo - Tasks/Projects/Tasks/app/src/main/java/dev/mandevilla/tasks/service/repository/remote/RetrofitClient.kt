package dev.mandevilla.tasks.service.repository.remote

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient private constructor() {
    companion object {
        private lateinit var instance: Retrofit

        private fun getInstance(): Retrofit {
            if (!::instance.isInitialized) {
                synchronized(RetrofitClient::class) {
                    val httpClient = OkHttpClient.Builder().build()
                    instance = Retrofit.Builder()
                        .baseUrl("http://devmasterteam.com/CursoAndroidAPI/")
                        .client(httpClient)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                }
            }
            return instance
        }

        fun <T> getService(serviceClass: Class<T>): T {
            return getInstance().create(serviceClass)
        }
    }
}
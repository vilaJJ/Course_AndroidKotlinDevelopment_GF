package dev.mandevilla.retrofitexample.client

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class JsonPlaceHolderClient private constructor() {
    companion object {
        private lateinit var _instance: Retrofit

        private val instance: Retrofit
            get() {
                if (!::_instance.isInitialized) {
                    synchronized(JsonPlaceHolderClient::class) {
                        val client = OkHttpClient.Builder()
                            .build()
                        val converterFactory = GsonConverterFactory.create()

                        _instance = Retrofit.Builder()
                            .baseUrl("https://jsonplaceholder.typicode.com/")
                            .client(client)
                            .addConverterFactory(converterFactory)
                            .build()
                    }
                }
                return _instance
            }

        fun <S> createService(serviceClass: Class<S>): S {
            return instance.create(serviceClass)
        }
    }
}
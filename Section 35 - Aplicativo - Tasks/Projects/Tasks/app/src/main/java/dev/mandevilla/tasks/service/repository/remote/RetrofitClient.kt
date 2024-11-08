package dev.mandevilla.tasks.service.repository.remote

import dev.mandevilla.tasks.domain.TaskHeaders
import dev.mandevilla.tasks.service.constants.TaskConstants
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient private constructor() {
    companion object {
        private lateinit var instance: Retrofit
        private var headers = TaskHeaders()

        private fun getInstance(): Retrofit {
            if (!::instance.isInitialized) {
                synchronized(RetrofitClient::class) {
                    val httpClient = OkHttpClient.Builder()
                        .addInterceptor { chain ->
                            val request = chain.request()
                                .newBuilder()
                                .addHeader(TaskConstants.Header.TOKEN_KEY, headers.token)
                                .addHeader(TaskConstants.Header.PERSON_KEY, headers.personKey)

                            chain.proceed(request.build())
                        }

                    instance = Retrofit.Builder()
                        .baseUrl("http://devmasterteam.com/CursoAndroidAPI/")
                        .client(httpClient.build())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                }
            }
            return instance
        }

        fun <T> getService(serviceClass: Class<T>): T {
            return getInstance().create(serviceClass)
        }

        fun addHeaders(taskHeaders: TaskHeaders) {
            headers = taskHeaders
        }
    }
}
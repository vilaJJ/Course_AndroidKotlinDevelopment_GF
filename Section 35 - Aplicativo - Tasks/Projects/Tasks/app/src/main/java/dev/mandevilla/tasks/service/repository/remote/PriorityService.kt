package dev.mandevilla.tasks.service.repository.remote

import dev.mandevilla.tasks.service.model.PriorityModel
import retrofit2.Call
import retrofit2.http.GET

interface PriorityService {
    @GET("Priority")
    fun listAll(): Call<List<PriorityModel>>
}
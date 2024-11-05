package dev.mandevilla.retrofitexample.service

import dev.mandevilla.retrofitexample.model.PostEntity
import retrofit2.Call
import retrofit2.http.GET

interface PostService {
    @GET("posts")
    fun getList(): Call<List<PostEntity>>
}
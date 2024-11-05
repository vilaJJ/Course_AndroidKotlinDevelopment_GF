package dev.mandevilla.retrofitexample.service

import dev.mandevilla.retrofitexample.model.CommentEntity
import retrofit2.Call
import retrofit2.http.GET

interface CommentService {
    @GET("comments")
    fun getList(): Call<List<CommentEntity>>
}
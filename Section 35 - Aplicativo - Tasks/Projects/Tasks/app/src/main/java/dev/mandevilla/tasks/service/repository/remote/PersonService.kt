package dev.mandevilla.tasks.service.repository.remote

import dev.mandevilla.tasks.service.model.PersonModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface PersonService {
    @POST("Authentication/Create")
    @FormUrlEncoded
    fun create(
        @Field("name")
        name: String,

        @Field("email")
        email: String,

        @Field("password")
        password: String,

        @Field("receivenews")
        receiveNews: Boolean = false
    ): Call<PersonModel>

    @POST("Authentication/Login")
    @FormUrlEncoded
    fun login(
        @Field("email")
        email: String,

        @Field("password")
        password: String
    ): Call<PersonModel>
}
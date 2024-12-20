package dev.mandevilla.retrofitexample.model

import com.google.gson.annotations.SerializedName

data class PostEntity(
    @SerializedName("id")
    val id: Int,
    @SerializedName("userId")
    val userId: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("body")
    val body: String
)
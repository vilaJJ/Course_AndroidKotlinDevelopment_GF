package dev.mandevilla.tasks.service.model

import com.google.gson.annotations.SerializedName

data class PersonModel(
    @SerializedName("token")
    val token: String,

    @SerializedName("personKey")
    val key: String,

    @SerializedName("name")
    val name: String
)

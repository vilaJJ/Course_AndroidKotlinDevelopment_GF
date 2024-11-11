package dev.mandevilla.tasks.service.repository.remote

import dev.mandevilla.tasks.service.model.TaskModel
import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface TaskService {
    @GET("Task/{id}")
    fun getById(
        @Path(value = "id", encoded = true)
        id: Int
    ): Call<TaskModel>

    @GET("Task")
    fun listAll(): Call<List<TaskModel>>

    @GET("Task/Next7Days")
    fun listNext7Days(): Call<List<TaskModel>>

    @GET("Task/Overdue")
    fun listOverdue(): Call<List<TaskModel>>

    @POST("Task")
    @FormUrlEncoded
    fun create(
        @Field("PriorityId")
        priorityId: Int,

        @Field("Description")
        description: String,

        @Field("DueDate")
        dueDate: String,

        @Field("Complete")
        complete: Boolean
    ): Call<Boolean>

    @PUT("Task")
    @FormUrlEncoded
    fun update(
        @Field("Id")
        id: Int,

        @Field("PriorityId")
        priorityId: Int,

        @Field("Description")
        description: String,

        @Field("DueDate")
        dueDate: String,

        @Field("Complete")
        complete: Boolean
    ): Call<Boolean>

    @PUT("Task/Complete")
    @FormUrlEncoded
    fun finish(
        @Field("Id")
        id: Int
    ): Call<Boolean>

    @PUT("Task/Undo")
    @FormUrlEncoded
    fun undo(
        @Field("Id")
        id: Int
    ): Call<Boolean>

    // TODO: Implementar configuração específica do DELETE.
    @DELETE("Task")
    @FormUrlEncoded
    fun remove(
        @Field("Id")
        id: Int
    ): Call<Boolean>
}
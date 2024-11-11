package dev.mandevilla.tasks.service.repository

import android.content.Context
import dev.mandevilla.tasks.service.constants.TaskConstants
import dev.mandevilla.tasks.service.listener.APIListener
import dev.mandevilla.tasks.service.model.PriorityModel
import dev.mandevilla.tasks.service.repository.local.TaskDatabase
import dev.mandevilla.tasks.service.repository.remote.PriorityService
import dev.mandevilla.tasks.service.repository.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PriorityRepository(context: Context) : BaseRepository(context) {
    private val local = TaskDatabase.getDatabase(context).getPriorityDAO()
    private val remote = RetrofitClient.getService(PriorityService::class.java)

    fun clear(): Int {
        return try {
            local.deleteAll()
        } catch (_: Exception) {
            -1
        }
    }

    fun downloadAll(listener: APIListener<List<PriorityModel>>) {
        with(remote.listAll()) {
            enqueue(object : Callback<List<PriorityModel>> {
                override fun onResponse(
                    call: Call<List<PriorityModel>>,
                    response: Response<List<PriorityModel>>
                ) {
                    when (response.code()) {
                        TaskConstants.Http.SUCCESS ->
                            response.body()?.let { listener.onSuccess(it) }
                        else -> {
                            val json = response.errorBody()?.string()
                            listener.onFailure(failureResponse(json))
                        }
                    }
                }

                override fun onFailure(call: Call<List<PriorityModel>>, throwable: Throwable) {
                    listener.onFailure(failureResponse())
                }
            })
        }
    }

    fun insert(values: List<PriorityModel>): Boolean {
        return try {
            local.insert(values)
            true
        } catch (_: Exception) {
            false
        }
    }

    fun select(): List<PriorityModel>? {
        return try {
            local.getAll()
        } catch (_: Exception) {
            null
        }
    }
}
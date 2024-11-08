package dev.mandevilla.tasks.service.repository

import android.content.Context
import com.google.gson.Gson
import dev.mandevilla.tasks.R
import dev.mandevilla.tasks.service.constants.TaskConstants
import dev.mandevilla.tasks.service.listener.APIListener
import dev.mandevilla.tasks.service.model.PersonModel
import dev.mandevilla.tasks.service.repository.remote.PersonService
import dev.mandevilla.tasks.service.repository.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PersonRepository(private val context: Context) {
    private val remote = RetrofitClient.getService(PersonService::class.java)

    fun login(email: String, password: String, listener: APIListener<PersonModel>) {
        with(remote.login(email, password)) {
            enqueue(object : Callback<PersonModel> {
                override fun onResponse(call: Call<PersonModel>, response: Response<PersonModel>) {
                    when (response.code()) {
                        TaskConstants.Http.SUCCESS ->
                            response.body()?.let { listener.onSuccess(it) }
                        else -> {
                            val json = response.errorBody()?.string()
                            listener.onFailure(failureResponse(json))
                        }
                    }
                }

                override fun onFailure(call: Call<PersonModel>, throwable: Throwable) {
                    listener.onFailure(failureResponse())
                }
            })
        }
    }

    private fun failureResponse(errorBody: String? = null): String {
        if (errorBody == null)
            return context.getString(R.string.error_unexpected)

        return Gson().fromJson(errorBody, String::class.java)
    }
}
package dev.mandevilla.tasks.service.repository

import android.content.Context
import com.google.gson.Gson
import dev.mandevilla.tasks.R

open class BaseRepository(protected val context: Context) {
    protected fun failureResponse(errorBody: String? = null): String {
        if (errorBody == null)
            return context.getString(R.string.error_unexpected)

        return Gson().fromJson(errorBody, String::class.java)
    }
}
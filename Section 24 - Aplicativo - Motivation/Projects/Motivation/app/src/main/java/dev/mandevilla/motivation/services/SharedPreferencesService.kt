package dev.mandevilla.motivation.services

import android.content.Context

internal class SharedPreferencesService(context: Context) {
    private val sharedPreferences =
        context.getSharedPreferences("Motiviation", Context.MODE_PRIVATE)

    fun getString(key: String, defaultValue: String? = null) =
        sharedPreferences.getString(key, defaultValue)

    fun setString(key: String, value: String) =
        sharedPreferences.edit().putString(key, value).apply()
}
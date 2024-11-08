package dev.mandevilla.tasks.service.repository

import android.content.Context
import android.content.SharedPreferences

class SecurityPreferences(context: Context) {
    private val preferences: SharedPreferences =
        context.getSharedPreferences("tasks_shared", Context.MODE_PRIVATE)

    private val editor: SharedPreferences.Editor = preferences.edit()

    fun store(key: String, value: String) {
        editor.putString(key, value).apply()
    }

    fun remove(key: String) {
        editor.remove(key).apply()
    }

    fun get(key: String): String? {
        return preferences.getString(key, null)
    }
}
package dev.mandevilla.tasks.service.repository

import android.content.Context
import dev.mandevilla.tasks.service.repository.remote.RetrofitClient
import dev.mandevilla.tasks.service.repository.remote.TaskService

class TaskRepository(context: Context) : BaseRepository(context) {
    private val remote = RetrofitClient.getService(TaskService::class.java)
}
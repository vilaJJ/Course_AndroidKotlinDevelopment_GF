package dev.mandevilla.tasks.service.repository.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dev.mandevilla.tasks.service.model.PriorityModel

@Database(entities = [PriorityModel::class], version = 1)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun getPriorityDAO(): PriorityDAO

    companion object {
        private lateinit var instance: TaskDatabase

        fun getDatabase(context: Context): TaskDatabase {
            if (!::instance.isInitialized) {
                synchronized(TaskDatabase::class) {
                    instance =
                        Room.databaseBuilder(context, TaskDatabase::class.java, "tasks_database")
                            .allowMainThreadQueries()
                            .build()
                }
            }
            return instance
        }
    }

}
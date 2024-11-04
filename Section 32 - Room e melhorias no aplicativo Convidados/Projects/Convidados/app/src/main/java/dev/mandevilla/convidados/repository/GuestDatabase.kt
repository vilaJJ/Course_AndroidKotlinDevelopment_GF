package dev.mandevilla.convidados.repository

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.room.Database
import androidx.room.DatabaseConfiguration
import androidx.room.InvalidationTracker
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper
import dev.mandevilla.convidados.constants.GuestDatabaseConstants
import dev.mandevilla.convidados.model.GuestModel

@Database(entities = [GuestModel::class], version = 1)
internal abstract class GuestDatabase : RoomDatabase() {
    abstract fun guestDAO(): GuestDAO

    companion object {
        private lateinit var instance: GuestDatabase

        fun getInstance(context: Context): GuestDatabase {
            if (!::instance.isInitialized) {
                synchronized(GuestDatabase::class) {
                    instance = Room
                        .databaseBuilder(context, GuestDatabase::class.java, "guest_database")
                        .allowMainThreadQueries()
                        .build()
                }
            }

            return instance
        }
    }
}
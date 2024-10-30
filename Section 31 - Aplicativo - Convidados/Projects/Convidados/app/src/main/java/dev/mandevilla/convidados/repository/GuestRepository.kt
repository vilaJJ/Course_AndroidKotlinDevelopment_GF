package dev.mandevilla.convidados.repository

import android.content.ContentValues
import android.content.Context
import dev.mandevilla.convidados.constants.GuestDatabaseConstants
import dev.mandevilla.convidados.model.GuestModel

class GuestRepository private constructor(context: Context) {
    private val database = GuestDatabase(context)

    companion object {
        private lateinit var instance: GuestRepository

        fun getInstance(context: Context): GuestRepository {
            if (!::instance.isInitialized)
                instance = GuestRepository(context)

            return instance
        }
    }

    fun insert(guest: GuestModel): Long {
        return try {
            val db = database.writableDatabase
            val tableName = GuestDatabaseConstants.Guest.TABLE_NAME
            val values = getGuestContentValues(guest)

            db.insert(tableName, null, values)
        } catch (_: Exception) {
            -1
        }
    }

    fun update(guest: GuestModel): Int {
        return try {
            val db = database.writableDatabase
            val tableName = GuestDatabaseConstants.Guest.TABLE_NAME
            val values = getGuestContentValues(guest)
            val whereClause = "id = ?"
            val whereArgs = arrayOf(guest.id.toString())

            db.update(tableName, values, whereClause, whereArgs)
        } catch (_: Exception) {
            -1
        }
    }

    private fun getGuestContentValues(guest: GuestModel): ContentValues {
        return with(ContentValues()) {
            put(GuestDatabaseConstants.Guest.Columns.NAME, guest.name)
            put(GuestDatabaseConstants.Guest.Columns.PRESENCE,guest.presence)
            this
        }
    }
}
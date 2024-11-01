package dev.mandevilla.convidados.repository

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
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

    fun getAll(): List<GuestModel> {
        return try {
            select()
        } catch (_: Exception) {
            listOf()
        }
    }

    fun getById(id: Int): GuestModel? {
        return try {
            val idColumnName = GuestDatabaseConstants.Guest.Columns.ID
            val whereClause = "$idColumnName = ?"
            val whereValues = arrayOf(id.toString())

            select(whereClause, whereValues).firstOrNull()
        } catch (_: Exception) {
            null
        }
    }

    fun getByPresence(isPresent: Boolean): List<GuestModel> {
        return try {
            val presenceColumnName = GuestDatabaseConstants.Guest.Columns.PRESENCE
            val presenceInt = if (isPresent) 1 else 0
            val whereClause = "$presenceColumnName = ?"
            val whereValues = arrayOf(presenceInt.toString())

            select(whereClause, whereValues)
        } catch (_: Exception) {
            listOf()
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
            val idColumName = GuestDatabaseConstants.Guest.Columns.ID
            val whereClause = "$idColumName = ?"
            val whereArgs = arrayOf(guest.id.toString())

            db.update(tableName, values, whereClause, whereArgs)
        } catch (_: Exception) {
            -1
        }
    }

    fun delete(id: Int): Int {
        return try {
            val db = database.writableDatabase
            val tableName = GuestDatabaseConstants.Guest.TABLE_NAME
            val idColumName = GuestDatabaseConstants.Guest.Columns.ID
            val whereClause = "$idColumName = ?"
            val whereArgs = arrayOf(id.toString())

            db.delete(tableName, whereClause, whereArgs)
        } catch (_: Exception) {
            -1
        }
    }

    private fun select(selection: String? = null, selectionArgs: Array<String>? = null): List<GuestModel> {
        var cursor: Cursor? = null

        return try {
            val db = database.readableDatabase
            val tableName = GuestDatabaseConstants.Guest.TABLE_NAME
            val columns = GuestDatabaseConstants.Guest.Columns.all

            cursor = db.query(
                tableName,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null,
                null
            )

            if (cursor == null || cursor.count == 0) {
                return listOf()
            }

            val idColumnIndex =
                cursor.getColumnIndex(GuestDatabaseConstants.Guest.Columns.ID)
            val nameColumnIndex =
                cursor.getColumnIndex(GuestDatabaseConstants.Guest.Columns.NAME)
            val presenceColumnIndex =
                cursor.getColumnIndex(GuestDatabaseConstants.Guest.Columns.PRESENCE)

            val values = mutableListOf<GuestModel>()

            while (cursor.moveToNext()) {
                val id = cursor.getInt(idColumnIndex)
                val name = cursor.getString(nameColumnIndex)
                val presence = cursor.getInt(presenceColumnIndex) > 0

                values.add(GuestModel(id, name, presence))
            }

            values.toList()
        } finally {
            cursor?.close()
        }
    }

    private fun getGuestContentValues(guest: GuestModel): ContentValues {
        return with(ContentValues()) {
            put(GuestDatabaseConstants.Guest.Columns.NAME, guest.name)
            put(GuestDatabaseConstants.Guest.Columns.PRESENCE, guest.presence)
            this
        }
    }
}
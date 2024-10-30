package dev.mandevilla.convidados.repository

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import dev.mandevilla.convidados.constants.GuestDatabaseConstants

class GuestDatabase(context: Context) : SQLiteOpenHelper(context, NAME, null, VERSION) {
    companion object {
        private const val NAME = "guest_database"
        private const val VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(GuestDatabaseConstants.Guest.CREATE_SCRIPT)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {}
}
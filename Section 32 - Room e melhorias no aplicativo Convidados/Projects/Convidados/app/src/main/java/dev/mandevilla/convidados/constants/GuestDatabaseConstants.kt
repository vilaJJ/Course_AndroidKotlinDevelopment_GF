package dev.mandevilla.convidados.constants

class GuestDatabaseConstants private constructor() {
    object Guest {
        const val TABLE_NAME = "Guest"

        const val CREATE_SCRIPT =
            "CREATE TABLE $TABLE_NAME (" +
                    "${Columns.ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "${Columns.NAME} TEXT," +
                    "${Columns.PRESENCE} INTEGER);"

        object Columns {
            const val ID = "id"
            const val NAME = "name"
            const val PRESENCE = "presence"

            val all = arrayOf(ID, NAME, PRESENCE)
        }
    }
}
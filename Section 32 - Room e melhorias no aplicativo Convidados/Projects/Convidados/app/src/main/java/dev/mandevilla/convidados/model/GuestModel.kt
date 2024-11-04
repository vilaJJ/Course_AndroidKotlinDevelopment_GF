package dev.mandevilla.convidados.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Guest")
class GuestModel() {
    constructor(name: String, presence: Boolean): this() {
        this.name = name
        this.presence = presence
    }

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    var id: Int = 0

    @ColumnInfo
    var name: String = ""

    @ColumnInfo
    var presence: Boolean = false
}
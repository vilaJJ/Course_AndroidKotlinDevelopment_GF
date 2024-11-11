package dev.mandevilla.tasks.service.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Priority")
data class PriorityModel(
    @SerializedName("Id")
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = false)
    val id: Int,

    @SerializedName("Description")
    @ColumnInfo(name = "description")
    val description: String
)
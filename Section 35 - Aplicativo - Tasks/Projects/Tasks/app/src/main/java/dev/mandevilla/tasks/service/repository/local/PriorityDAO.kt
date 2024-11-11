package dev.mandevilla.tasks.service.repository.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import dev.mandevilla.tasks.service.model.PriorityModel

@Dao
interface PriorityDAO {
    @Query("DELETE FROM Priority")
    fun deleteAll(): Int

    @Query("SELECT * FROM Priority")
    fun getAll(): List<PriorityModel>

    @Query("SELECT * FROM Priority WHERE id = :id")
    fun getById(id: Int): PriorityModel

    @Insert
    fun insert(values: List<PriorityModel>)
}
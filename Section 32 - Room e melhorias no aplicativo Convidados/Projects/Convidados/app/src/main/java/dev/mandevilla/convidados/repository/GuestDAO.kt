package dev.mandevilla.convidados.repository

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import dev.mandevilla.convidados.model.GuestModel

@Dao
internal interface GuestDAO {
    @Delete
    fun delete(guest: GuestModel): Int

    @Insert
    fun insert(guest: GuestModel): Long

    @Query("SELECT * FROM Guest")
    fun getAll(): List<GuestModel>

    @Query("SELECT * FROM Guest WHERE id = :id")
    fun getById(id: Int): GuestModel

    @Query("SELECT * FROM Guest WHERE presence = :isPresent")
    fun getByPresence(isPresent: Boolean): List<GuestModel>

    @Update
    fun update(guest: GuestModel): Int
}
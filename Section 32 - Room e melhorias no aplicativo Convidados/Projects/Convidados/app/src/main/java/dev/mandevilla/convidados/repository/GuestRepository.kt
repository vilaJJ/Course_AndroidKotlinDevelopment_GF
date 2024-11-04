package dev.mandevilla.convidados.repository

import android.content.Context
import dev.mandevilla.convidados.model.GuestModel

internal class GuestRepository(context: Context) {
    private val database = GuestDatabase.getInstance(context).guestDAO()

    fun getAll(): List<GuestModel> {
        return try {
            database.getAll()
        } catch (_: Exception) {
            listOf()
        }
    }

    fun getById(id: Int): GuestModel? {
        return try {
            database.getById(id)
        } catch (_: Exception) {
            null
        }
    }

    fun getByPresence(isPresent: Boolean): List<GuestModel> {
        return try {
            database.getByPresence(isPresent)
        } catch (_: Exception) {
            listOf()
        }
    }

    fun insert(guest: GuestModel): Long {
        return try {
            database.insert(guest)
        } catch (_: Exception) {
            -1
        }
    }

    fun update(guest: GuestModel): Int {
        return try {
            database.update(guest)
        } catch (_: Exception) {
            -1
        }
    }

    fun delete(guest: GuestModel): Int {
        return try {
            database.delete(guest)
        } catch (_: Exception) {
            -1
        }
    }
}
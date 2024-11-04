package dev.mandevilla.convidados.viewmodel.fragment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dev.mandevilla.convidados.model.GuestModel
import dev.mandevilla.convidados.repository.GuestRepository

class GuestsViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = GuestRepository(application)
    private val _guests = MutableLiveData<List<GuestModel>>()

    val guests: LiveData<List<GuestModel>> = _guests

    fun getAllGuests() {
        _guests.value = repository.getAll()
    }

    fun getPresents() {
        _guests.value = getByPresence(true)
    }

    fun getAbsents() {
        _guests.value = getByPresence(false)
    }

    fun deleteGuest(guest: GuestModel) {
        repository.delete(guest)
    }

    private fun getByPresence(isPresent: Boolean) =
        repository.getByPresence(isPresent)
}
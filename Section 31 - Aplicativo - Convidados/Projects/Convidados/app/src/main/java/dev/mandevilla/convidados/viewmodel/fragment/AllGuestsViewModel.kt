package dev.mandevilla.convidados.viewmodel.fragment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.mandevilla.convidados.model.GuestModel
import dev.mandevilla.convidados.repository.GuestRepository

class AllGuestsViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = GuestRepository.getInstance(application)
    private val _guests = MutableLiveData<List<GuestModel>>()

    val guests: LiveData<List<GuestModel>> = _guests

    fun getAllGuests() {
        _guests.value = repository.getAll()
    }

    fun deleteGuest(guest: GuestModel) {
        repository.delete(guest.id)
    }
}
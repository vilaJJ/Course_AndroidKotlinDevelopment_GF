package dev.mandevilla.convidados.viewmodel.activity

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dev.mandevilla.convidados.model.GuestModel
import dev.mandevilla.convidados.repository.GuestRepository

class GuestFormViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = GuestRepository.getInstance(application)

    private val _name = MutableLiveData<String>()
    private val _isPresent = MutableLiveData(true)

    val name: LiveData<String> = _name
    val isPresent: LiveData<Boolean> = _isPresent

    fun updatePresentState(isPresent: Boolean) {
        this._isPresent.value = isPresent
    }

    fun saveGuest(guest: GuestModel) {
        if (guest.id == 0)
            insertGuest(guest)
        else
            updateGuest(guest)
    }

    private fun insertGuest(guest: GuestModel) {
        repository.insert(guest)
    }

    private fun updateGuest(guest: GuestModel) {
        repository.update(guest)
    }

    fun loadGuest(id: Int) {
        val guest = repository.getById(id) ?: return
        _name.value = guest.name
        _isPresent.value = guest.presence
    }
}
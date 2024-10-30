package dev.mandevilla.convidados.viewmodel.activity

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dev.mandevilla.convidados.model.GuestModel
import dev.mandevilla.convidados.repository.GuestRepository

class GuestFormViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = GuestRepository.getInstance(application)

    private val isPresent = MutableLiveData<Boolean>()

    init {
        isPresent.value = true
    }

    fun isPresent(): LiveData<Boolean> = isPresent

    fun updatePresentState(isPresent: Boolean) {
        this.isPresent.value = isPresent
    }

    fun insert(guest: GuestModel): Boolean {
        return repository.insert(guest) > 0
    }

    fun update(guest: GuestModel): Boolean {
        return repository.update(guest) > 0
    }
}
package dev.mandevilla.convidados.viewmodel.activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.mandevilla.convidados.repository.GuestRepository

class GuestFormViewModel : ViewModel() {
    private val repository = GuestRepository.getInstance()

    private val isPresent = MutableLiveData<Boolean>()

    init {
        isPresent.value = true
    }

    fun isPresent(): LiveData<Boolean> = isPresent

    fun updatePresentState(isPresent: Boolean) {
        this.isPresent.value = isPresent
    }
}
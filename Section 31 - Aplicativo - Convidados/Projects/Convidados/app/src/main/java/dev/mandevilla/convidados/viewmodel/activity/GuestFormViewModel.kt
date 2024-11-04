package dev.mandevilla.convidados.viewmodel.activity

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dev.mandevilla.convidados.R
import dev.mandevilla.convidados.model.GuestFormResult
import dev.mandevilla.convidados.model.GuestModel
import dev.mandevilla.convidados.repository.GuestRepository

class GuestFormViewModel(private val application: Application) : AndroidViewModel(application) {
    private val repository = GuestRepository.getInstance(application)

    private var _guestId: Int? = null
    private val _name = MutableLiveData<String>()
    private val _isPresent = MutableLiveData(true)

    val guestId get() = _guestId
    val name: LiveData<String> = _name
    val isPresent: LiveData<Boolean> = _isPresent

    fun setGuestId(id: Int) {
        _guestId = id
    }

    fun updatePresentState(isPresent: Boolean) {
        this._isPresent.value = isPresent
    }

    fun loadGuest() {
        if (_guestId == null)
            return

        val guest = repository.getById(_guestId!!) ?: return
        _name.value = guest.name
        _isPresent.value = guest.presence
    }

    fun saveGuest(guest: GuestModel): GuestFormResult {
        val isInsertion = guest.id == 0
        val success = if (isInsertion) insertGuest(guest) else updateGuest(guest)
        val messageResultId = getMessageResult(success, isInsertion)

        return GuestFormResult(success, messageResultId)
    }

    private fun insertGuest(guest: GuestModel): Boolean {
        return repository.insert(guest) > 0
    }

    private fun updateGuest(guest: GuestModel): Boolean {
        return repository.update(guest) > 0
    }

    private fun getMessageResult(success: Boolean, isInsertion: Boolean): Int {
        return if (success) {
            if (isInsertion) R.string.guest_successfully_added
            else R.string.guest_updated_successfully
        } else {
            if (isInsertion) R.string.unable_add_guest
            else R.string.unable_update_guest
        }
    }
}
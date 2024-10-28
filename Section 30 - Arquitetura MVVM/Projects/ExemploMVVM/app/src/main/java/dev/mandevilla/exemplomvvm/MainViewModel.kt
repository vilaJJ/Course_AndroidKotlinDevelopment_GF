package dev.mandevilla.exemplomvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val personRepository = PersonRepository()

    private val textWelcome = MutableLiveData<String>()
    private val login = MutableLiveData<Boolean>()

    init {
        textWelcome.value = "Olá, mundo!"
    }

    fun welcome(): LiveData<String> = textWelcome
    fun login(): LiveData<Boolean> = login

    fun doLogin(email: String, password: String) {
        login.value = personRepository.login(email, password)
    }
}
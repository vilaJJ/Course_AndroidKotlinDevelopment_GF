package dev.mandevilla.tasks.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import dev.mandevilla.tasks.service.listener.APIListener
import dev.mandevilla.tasks.service.model.PersonModel
import dev.mandevilla.tasks.service.repository.PersonRepository

class LoginViewModel(application: Application) : AndroidViewModel(application) {
    private val personRepository = PersonRepository()

    fun doLogin(email: String, password: String) {
        personRepository.login(email, password, object : APIListener<PersonModel> {
            override fun onSuccess(result: PersonModel) {
                TODO("Not yet implemented")
            }

            override fun onFailure(message: String) {
                TODO("Not yet implemented")
            }
        })
    }

    fun verifyLoggedUser() {}
}
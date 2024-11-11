package dev.mandevilla.tasks.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dev.mandevilla.tasks.domain.TaskHeaders
import dev.mandevilla.tasks.domain.ValidationResult
import dev.mandevilla.tasks.service.constants.TaskConstants
import dev.mandevilla.tasks.service.listener.APIListener
import dev.mandevilla.tasks.service.model.PersonModel
import dev.mandevilla.tasks.service.model.PriorityModel
import dev.mandevilla.tasks.service.repository.PersonRepository
import dev.mandevilla.tasks.service.repository.PriorityRepository
import dev.mandevilla.tasks.service.repository.SecurityPreferences
import dev.mandevilla.tasks.service.repository.remote.RetrofitClient

class LoginViewModel(application: Application) : AndroidViewModel(application) {
    private val personRepository = PersonRepository(application)
    private val priorityRepository = PriorityRepository(application)
    private val securityPreferences = SecurityPreferences(application)

    private val _validationResult = MutableLiveData<ValidationResult>()

    val validationResult: LiveData<ValidationResult> = _validationResult

    fun doLogin(email: String, password: String) {
        personRepository.login(email, password, object : APIListener<PersonModel> {
            override fun onSuccess(result: PersonModel) {
                saveUserAuthData(result)
                _validationResult.value = ValidationResult.getSuccess()
            }

            override fun onFailure(message: String) {
                _validationResult.value = ValidationResult.getFailure(message)
            }
        })
    }

    fun verifyLoggedUser(): Boolean {
        val token: String?
        val personKey: String?

        with(securityPreferences) {
            token = get(TaskConstants.SharedKeys.TOKEN)
            personKey = get(TaskConstants.SharedKeys.PERSON_KEY)
        }

        val isLogged = !(token.isNullOrBlank() && personKey.isNullOrBlank())

        if (isLogged)
            setHeaders(TaskHeaders(token!!, personKey!!))
        else
            downloadPriorityData()

        return isLogged
    }

    private fun saveUserAuthData(person: PersonModel) {
        with(securityPreferences) {
            store(TaskConstants.SharedKeys.PERSON_KEY, person.key)
            store(TaskConstants.SharedKeys.TOKEN, person.token)
            store(TaskConstants.SharedKeys.PERSON_NAME, person.name)
        }
        setHeaders(TaskHeaders(person.token, person.key))
    }

    private fun setHeaders(headers: TaskHeaders) {
        RetrofitClient.addHeaders(headers)
    }

    private fun downloadPriorityData() {
        priorityRepository.downloadAll(object : APIListener<List<PriorityModel>> {
            override fun onSuccess(result: List<PriorityModel>) {
                priorityRepository.clear()
                priorityRepository.insert(result)
                val a = priorityRepository.select()
            }

            override fun onFailure(message: String) {
                _validationResult.value = ValidationResult.getFailure(message)
            }
        })
    }
}
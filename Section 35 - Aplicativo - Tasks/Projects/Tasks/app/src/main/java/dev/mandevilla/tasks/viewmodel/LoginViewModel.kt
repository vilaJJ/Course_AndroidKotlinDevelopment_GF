package dev.mandevilla.tasks.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class LoginViewModel(application: Application) : AndroidViewModel(application) {
    fun doLogin(email: String, password: String) {}
    fun verifyLoggedUser() {}
}
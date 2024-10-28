package dev.mandevilla.exemplomvvm

class PersonRepository {
    fun login(email: String, password: String): Boolean {
        return email.isNotBlank() && password.isNotBlank()
    }
}
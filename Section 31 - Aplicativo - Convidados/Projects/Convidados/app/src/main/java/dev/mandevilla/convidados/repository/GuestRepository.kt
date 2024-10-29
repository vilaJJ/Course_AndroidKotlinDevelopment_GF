package dev.mandevilla.convidados.repository

class GuestRepository private constructor() {
    companion object {
        private lateinit var instance: GuestRepository

        fun getInstance(): GuestRepository {
            if (!::instance.isInitialized)
                instance = GuestRepository()

            return instance
        }
    }
}
package dev.mandevilla.convidados.model

data class GuestModel(
    var id: Int = 0,
    val name: String,
    val presence: Boolean
)
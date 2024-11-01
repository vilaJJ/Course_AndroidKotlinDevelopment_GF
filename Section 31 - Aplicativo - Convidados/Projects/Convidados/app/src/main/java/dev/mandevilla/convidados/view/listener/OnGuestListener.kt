package dev.mandevilla.convidados.view.listener

import dev.mandevilla.convidados.model.GuestModel

interface OnGuestListener {
    fun onClick(guest: GuestModel)
    fun onDelete(guest: GuestModel)
}
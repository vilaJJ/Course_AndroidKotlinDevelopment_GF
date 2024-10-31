package dev.mandevilla.convidados.view.viewholder

import androidx.recyclerview.widget.RecyclerView
import dev.mandevilla.convidados.databinding.RowGuestBinding
import dev.mandevilla.convidados.model.GuestModel

class GuestsViewHolder(private val bind: RowGuestBinding) : RecyclerView.ViewHolder(bind.root) {
    fun bind(guest: GuestModel) {
        bind.textName.text = guest.name
    }
}
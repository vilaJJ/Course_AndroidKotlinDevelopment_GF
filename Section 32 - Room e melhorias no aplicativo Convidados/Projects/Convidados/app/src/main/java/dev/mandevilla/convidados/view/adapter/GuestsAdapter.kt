package dev.mandevilla.convidados.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.mandevilla.convidados.databinding.RowGuestBinding
import dev.mandevilla.convidados.model.GuestModel
import dev.mandevilla.convidados.view.listener.OnGuestListener
import dev.mandevilla.convidados.view.viewholder.GuestsViewHolder

class GuestsAdapter : RecyclerView.Adapter<GuestsViewHolder>() {
    private lateinit var listener: OnGuestListener
    private var guestsList: List<GuestModel> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuestsViewHolder {
        val itemBinding = RowGuestBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return GuestsViewHolder(itemBinding, listener)
    }

    override fun getItemCount(): Int {
        return guestsList.count()
    }

    override fun onBindViewHolder(holder: GuestsViewHolder, position: Int) {
        holder.bind(guestsList[position])
    }

    fun attachListener(listener: OnGuestListener) {
        this.listener = listener
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateGuests(values: List<GuestModel>) {
        guestsList = values
        notifyDataSetChanged()
    }
}
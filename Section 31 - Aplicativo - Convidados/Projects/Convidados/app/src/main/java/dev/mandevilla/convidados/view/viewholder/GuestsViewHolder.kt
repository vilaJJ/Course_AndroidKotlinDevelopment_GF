package dev.mandevilla.convidados.view.viewholder

import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat.getString
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import dev.mandevilla.convidados.R
import dev.mandevilla.convidados.databinding.RowGuestBinding
import dev.mandevilla.convidados.model.GuestModel
import dev.mandevilla.convidados.view.listener.OnGuestListener

class GuestsViewHolder(
    private val bind: RowGuestBinding,
    private val listener: OnGuestListener
) : RecyclerView.ViewHolder(bind.root) {
    fun bind(guest: GuestModel) {
        setListeners(guest)
        bind.textName.text = guest.name
    }

    private fun setListeners(guest: GuestModel) {
        bind.textName.setOnClickListener { listener.onClick(guest) }

        bind.textName.setOnLongClickListener {
            val context = itemView.context
            val title = getString(context, R.string.guest_removal)
            val guestNameConstraint = getString(context, R.string.guest_name_constraint)

            val message = getString(
                context,
                R.string.guest_removal_question
            ).replace(
                guestNameConstraint,
                guest.name
            )

            val positiveText = getString(context, R.string.yes)
            val negativeText = getString(context, R.string.no)

            AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(positiveText) { _, _ ->
                    listener.onDelete(guest)

                    val messageConfimation = getString(
                        context,
                        R.string.guest_removal_confirmation
                    ).replace(
                        guestNameConstraint,
                        guest.name
                    )
                    Snackbar.make(itemView, messageConfimation, Snackbar.LENGTH_SHORT).show()
                }
                .setNegativeButton(negativeText, null)
                .create()
                .show()

            true
        }
    }
}
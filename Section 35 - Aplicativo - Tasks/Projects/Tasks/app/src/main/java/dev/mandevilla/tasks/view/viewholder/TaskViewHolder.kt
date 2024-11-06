package dev.mandevilla.tasks.view.viewholder

import android.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import dev.mandevilla.tasks.R
import dev.mandevilla.tasks.databinding.RowTaskListBinding
import dev.mandevilla.tasks.service.listener.TaskListener
import dev.mandevilla.tasks.service.model.TaskModel

class TaskViewHolder(private val itemBinding: RowTaskListBinding, val listener: TaskListener) :
    RecyclerView.ViewHolder(itemBinding.root) {

    fun bindData(task: TaskModel) {
        itemBinding.textDescription.text = ""
        itemBinding.textPriority.text = ""
        itemBinding.textDueDate.text = ""

        // Eventos
        // itemBinding.textDescription.setOnClickListener { listener.onListClick(task.id) }
        // itemBinding.imageTask.setOnClickListener { }

        itemBinding.textDescription.setOnLongClickListener {
            AlertDialog.Builder(itemView.context)
                .setTitle(R.string.removal_task)
                .setMessage(R.string.remove_task_question)
                .setPositiveButton(R.string.yes) { _, _ ->
                    // listener.onDeleteClick(task.id)
                }
                .setNeutralButton(R.string.cancel, null)
                .show()
            true
        }
    }
}
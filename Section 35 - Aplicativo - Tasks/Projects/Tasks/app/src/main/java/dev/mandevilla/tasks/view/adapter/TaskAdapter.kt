package dev.mandevilla.tasks.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.mandevilla.tasks.databinding.RowTaskListBinding
import dev.mandevilla.tasks.service.listener.TaskListener
import dev.mandevilla.tasks.service.model.TaskModel
import dev.mandevilla.tasks.view.viewholder.TaskViewHolder

class TaskAdapter : RecyclerView.Adapter<TaskViewHolder>() {
    private var listTasks: List<TaskModel> = arrayListOf()
    private lateinit var listener: TaskListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemBinding = RowTaskListBinding.inflate(inflater, parent, false)
        return TaskViewHolder(itemBinding, listener)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bindData(listTasks[position])
    }

    override fun getItemCount(): Int {
        return listTasks.count()
    }

    fun attachListener(taskListener: TaskListener) {
        listener = taskListener
    }
}
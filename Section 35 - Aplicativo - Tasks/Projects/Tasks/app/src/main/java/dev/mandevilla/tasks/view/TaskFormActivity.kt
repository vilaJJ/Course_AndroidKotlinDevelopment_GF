package dev.mandevilla.tasks.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import dev.mandevilla.tasks.viewmodel.TaskFormViewModel
import dev.mandevilla.tasks.databinding.ActivityTaskFormBinding

class TaskFormActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var viewModel: TaskFormViewModel
    private lateinit var binding: ActivityTaskFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[TaskFormViewModel::class.java]
        binding = ActivityTaskFormBinding.inflate(layoutInflater)

        setOnClickListeners()
        setContentView(binding.root)
    }

    override fun onClick(v: View) {
        TODO("Not yet implemented")
    }

    private fun setOnClickListeners() {
        binding.buttonSave.setOnClickListener(this)
        binding.buttonDate.setOnClickListener(this)
    }
}
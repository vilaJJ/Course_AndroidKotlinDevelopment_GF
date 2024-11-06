package dev.mandevilla.tasks.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import dev.mandevilla.tasks.databinding.FragmentNextTasksBinding
import dev.mandevilla.tasks.viewmodel.TaskListViewModel

class NextTasksFragment : Fragment() {
    private lateinit var viewModel: TaskListViewModel
    private var _binding: FragmentNextTasksBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, b: Bundle?): View {
        viewModel = ViewModelProvider(this)[TaskListViewModel::class.java]
        _binding = FragmentNextTasksBinding.inflate(inflater, container, false)

        val textView: TextView = binding.textGallery

        viewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
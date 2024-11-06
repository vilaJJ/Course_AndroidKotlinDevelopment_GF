package dev.mandevilla.tasks.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import dev.mandevilla.tasks.databinding.FragmentExpiredTasksBinding
import dev.mandevilla.tasks.viewmodel.TaskListViewModel

class ExpiredTasksFragment : Fragment() {
    private lateinit var slideshowViewModel: TaskListViewModel
    private var _binding: FragmentExpiredTasksBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        slideshowViewModel = ViewModelProvider(this)[TaskListViewModel::class.java]
        _binding = FragmentExpiredTasksBinding.inflate(inflater, container, false)
        val textView: TextView = binding.textSlideshow
        slideshowViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
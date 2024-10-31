package dev.mandevilla.convidados.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dev.mandevilla.convidados.databinding.FragmentAllGuestsBinding
import dev.mandevilla.convidados.view.adapter.GuestsAdapter
import dev.mandevilla.convidados.viewmodel.fragment.AllGuestsViewModel

class AllGuestsFragment : Fragment() {
    private lateinit var viewModel: AllGuestsViewModel

    private var _binding: FragmentAllGuestsBinding? = null

    private val binding get() = _binding!!
    private val adapter = GuestsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[AllGuestsViewModel::class.java]
        _binding = FragmentAllGuestsBinding.inflate(inflater, container, false)

        setObservers()
        initialize()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setObservers() {
        viewModel.guests.observe(viewLifecycleOwner) {
            adapter.updateGuests(it)
        }
    }

    private fun initialize() {
        configureRecyclerAllGuests()
        getAllGuests()
    }

    private fun configureRecyclerAllGuests() {
        binding.recyclerAllGuests.layoutManager = LinearLayoutManager(context)
        binding.recyclerAllGuests.adapter = adapter
    }

    private fun getAllGuests() {
        viewModel.getAllGuests()
    }
}
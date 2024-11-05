package dev.mandevilla.convidados.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dev.mandevilla.convidados.constants.GuestDatabaseConstants
import dev.mandevilla.convidados.databinding.FragmentAbsentsBinding
import dev.mandevilla.convidados.model.GuestModel
import dev.mandevilla.convidados.view.activity.GuestFormActivity
import dev.mandevilla.convidados.view.adapter.GuestsAdapter
import dev.mandevilla.convidados.view.listener.OnGuestListener
import dev.mandevilla.convidados.viewmodel.fragment.GuestsViewModel

class AbsentsFragment : Fragment() {
    private lateinit var viewModel: GuestsViewModel

    private var _binding: FragmentAbsentsBinding? = null
    private val binding get() = _binding!!

    private val adapter = GuestsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[GuestsViewModel::class.java]
        _binding = FragmentAbsentsBinding.inflate(inflater, container, false)

        setObservers()
        initialize()
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        getAbsents()
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
        configureRecyclerGuestsAbsents()
        setOnGuestListener()
    }

    private fun configureRecyclerGuestsAbsents() {
        binding.recyclerGuestsAbsents.layoutManager = LinearLayoutManager(context)
        binding.recyclerGuestsAbsents.adapter = adapter
    }

    private fun setOnGuestListener() {
        adapter.attachListener(object : OnGuestListener {
            override fun onClick(guest: GuestModel) {
                val intent = Intent(context, GuestFormActivity::class.java)
                val bundle = Bundle()

                bundle.putInt(GuestDatabaseConstants.Guest.Columns.ID, guest.id)
                intent.putExtras(bundle)
                startActivity(intent)
            }

            override fun onDelete(guest: GuestModel) {
                deleteGuest(guest)
                getAbsents()
            }
        })
    }

    private fun getAbsents() {
        viewModel.getAbsents()
    }

    private fun deleteGuest(guest: GuestModel) {
        viewModel.deleteGuest(guest)
    }
}
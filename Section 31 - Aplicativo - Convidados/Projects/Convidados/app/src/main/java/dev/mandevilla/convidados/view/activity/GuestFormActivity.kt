package dev.mandevilla.convidados.view.activity

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import dev.mandevilla.convidados.databinding.ActivityGuestFormBinding
import dev.mandevilla.convidados.viewmodel.activity.GuestFormViewModel

class GuestFormActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityGuestFormBinding
    private lateinit var viewModel: GuestFormViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGuestFormBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[GuestFormViewModel::class.java]

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(binding.root.id)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setObservers()
        setupSetOnClickListener()
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            binding.radioButtonPresent.id,
            binding.radioButtonAbsent.id -> handleRadioButtonStateClick()

            binding.buttonSave.id -> handleButtonSaveClick()
        }
    }

    private fun setupSetOnClickListener() {
        binding.radioButtonPresent.setOnClickListener(this)
        binding.radioButtonAbsent.setOnClickListener(this)
        binding.buttonSave.setOnClickListener(this)
    }

    private fun setObservers() {
        val owner = this

        with(viewModel) {
            isPresent().observe(owner) {
                binding.radioButtonPresent.isChecked = it
            }
        }
    }

    private fun handleRadioButtonStateClick() {
        viewModel.updatePresentState(binding.radioButtonPresent.isChecked)
    }

    private fun handleButtonSaveClick() {

    }
}
package dev.mandevilla.convidados.view.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import dev.mandevilla.convidados.R
import dev.mandevilla.convidados.constants.GuestDatabaseConstants
import dev.mandevilla.convidados.databinding.ActivityGuestFormBinding
import dev.mandevilla.convidados.model.GuestModel
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
        loadData()
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            binding.radioButtonPresent.id,
            binding.radioButtonAbsent.id -> handleRadioButtonStateClick()

            binding.buttonSave.id -> handleButtonSaveClick()
        }
    }

    private fun setObservers() {
        val owner = this

        with(viewModel) {
            name.observe(owner) {
                binding.editTextGuestName.setText(it)
            }
            isPresent.observe(owner) {
                binding.radioButtonPresent.isChecked = it
                binding.radioButtonAbsent.isChecked = !it
            }
        }
    }

    private fun setupSetOnClickListener() {
        binding.radioButtonPresent.setOnClickListener(this)
        binding.radioButtonAbsent.setOnClickListener(this)
        binding.buttonSave.setOnClickListener(this)
    }

    private fun loadData() {
        val bundle = intent.extras ?: return
        viewModel.setGuestId(bundle.getInt(GuestDatabaseConstants.Guest.Columns.ID))
        setupActivityToUpdateGuest()
        getGuestById()
    }

    private fun setupActivityToUpdateGuest() {
        binding.textTitle.text = getString(R.string.guest_update)
        binding.buttonSave.text = getString(R.string.update)
    }

    private fun handleRadioButtonStateClick() {
        viewModel.updatePresentState(binding.radioButtonPresent.isChecked)
    }

    private fun handleButtonSaveClick() {
        val name = binding.editTextGuestName.text.trim().toString()
        val presence = binding.radioButtonPresent.isChecked

        val guest = GuestModel(
            name = name,
            presence = presence
        )

        if (viewModel.guestId != null)
            guest.id = viewModel.guestId!!

        val result = saveGuest(guest)
        showToast(result.messageId)

        if (result.success) {
            finish()
        }
    }

    private fun getGuestById() {
        viewModel.loadGuest()
    }

    private fun saveGuest(guest: GuestModel) = viewModel.saveGuest(guest)

    private fun showToast(resourceId: Int) {
        Toast.makeText(applicationContext, resourceId, Toast.LENGTH_SHORT).show()
    }
}
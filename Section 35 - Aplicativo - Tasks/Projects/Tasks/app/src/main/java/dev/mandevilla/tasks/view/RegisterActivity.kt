package dev.mandevilla.tasks.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import dev.mandevilla.tasks.R
import dev.mandevilla.tasks.databinding.ActivityLoginBinding
import dev.mandevilla.tasks.databinding.ActivityRegisterBinding
import dev.mandevilla.tasks.viewmodel.LoginViewModel
import dev.mandevilla.tasks.viewmodel.RegisterViewModel

class RegisterActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var viewModel: RegisterViewModel
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[RegisterViewModel::class.java]
        binding = ActivityRegisterBinding.inflate(layoutInflater)

        setOnClickListeners()
        setContentView(binding.root)
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }

    private fun setOnClickListeners() {
        binding.buttonSave.setOnClickListener(this)
    }
}
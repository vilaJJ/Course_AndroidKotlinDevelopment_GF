package dev.mandevilla.tasks.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import dev.mandevilla.tasks.databinding.ActivityLoginBinding
import dev.mandevilla.tasks.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var viewModel: LoginViewModel
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        binding = ActivityLoginBinding.inflate(layoutInflater)

        setContentView(binding.root)
        setOnClickListeners()
        observe()
    }

    override fun onClick(v: View) {
    }

    private fun setOnClickListeners() {
        binding.buttonLogin.setOnClickListener(this)
        binding.textRegister.setOnClickListener(this)
    }

    private fun observe() {
    }
}
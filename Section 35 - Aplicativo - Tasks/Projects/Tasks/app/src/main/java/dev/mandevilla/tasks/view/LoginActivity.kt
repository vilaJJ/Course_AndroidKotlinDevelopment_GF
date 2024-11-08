package dev.mandevilla.tasks.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import dev.mandevilla.tasks.databinding.ActivityLoginBinding
import dev.mandevilla.tasks.domain.ValidationResult
import dev.mandevilla.tasks.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var viewModel: LoginViewModel
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        binding = ActivityLoginBinding.inflate(layoutInflater)

        if (verifyLoggedUser())
            return

        setContentView(binding.root)
        setOnClickListeners()
        observe()
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            binding.buttonLogin.id -> handleLogin()
        }
    }

    private fun verifyLoggedUser(): Boolean {
        val isLogged = viewModel.verifyLoggedUser()

        if (isLogged)
            goToMainActivity()

        return isLogged
    }

    private fun setOnClickListeners() {
        binding.buttonLogin.setOnClickListener(this)
        binding.textRegister.setOnClickListener(this)
    }

    private fun observe() {
        viewModel.validationResult.observe(this) { handleValidationResult(it) }
    }

    private fun handleLogin() {
        val email = binding.editEmail.text.toString()
        val password = binding.editPassword.text.toString()

        viewModel.doLogin(email, password)
    }

    private fun handleValidationResult(result: ValidationResult) {
        with(result) {
            if (success)
                goToMainActivity()
            else
                showToast(message!!)
        }
    }

    private fun goToMainActivity() {
        val intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun showToast(message: String) {
        with(Toast.makeText(application, message, Toast.LENGTH_SHORT)) {
            show()
        }
    }
}
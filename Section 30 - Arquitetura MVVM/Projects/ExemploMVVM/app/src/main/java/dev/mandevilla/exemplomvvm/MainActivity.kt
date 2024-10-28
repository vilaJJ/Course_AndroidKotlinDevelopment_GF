package dev.mandevilla.exemplomvvm

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import dev.mandevilla.exemplomvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        setObservers()
        setOnClickListeners()
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            binding.buttonLogin.id -> handleLoginClick()
        }
    }

    private fun setObservers() {
        val owner = this

        with(viewModel) {
            welcome().observe(owner) {
                binding.textViewHelloWorld.text = it
            }
            login().observe(owner) {
                val resultResourceId = if (it) R.string.successful_login else R.string.incorrect_login
                showToast(resultResourceId)
            }
        }
    }

    private fun setOnClickListeners() {
        binding.buttonLogin.setOnClickListener(this)
    }

    private fun handleLoginClick() {
        val email = binding.editTextEmail.text.toString()
        val password = binding.editTextPassword.text.toString()

        viewModel.doLogin(email, password)
    }

    private fun showToast(resourceId: Int) {
        Toast.makeText(this, resourceId, Toast.LENGTH_SHORT).show()
    }
}
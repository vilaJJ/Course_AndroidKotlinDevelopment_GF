package dev.mandevilla.motivation.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import dev.mandevilla.motivation.constants.SharedPreferencesConstants
import dev.mandevilla.motivation.R
import dev.mandevilla.motivation.databinding.ActivityMainBinding
import dev.mandevilla.motivation.services.SharedPreferencesService

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setOnClickListenerComponents()
        loadUserName()
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            binding.buttonNewPhrase.id -> showNewPhrase()
        }
    }

    private fun setOnClickListenerComponents() {
        binding.buttonNewPhrase.setOnClickListener(this)
    }

    private fun showNewPhrase() {}

    private fun loadUserName() {
        val hello = getString(R.string.hello)
        val userName = getUserNameFromPreferences() ?: R.string.user.toString().lowercase()

        val valueToShow = "$hello, $userName!"
        binding.textUserName.text = valueToShow
    }

    private fun getUserNameFromPreferences(): String? {
        with(SharedPreferencesService(this)) {
            return getString(SharedPreferencesConstants.Keys.USER_NAME)
        }
    }
}
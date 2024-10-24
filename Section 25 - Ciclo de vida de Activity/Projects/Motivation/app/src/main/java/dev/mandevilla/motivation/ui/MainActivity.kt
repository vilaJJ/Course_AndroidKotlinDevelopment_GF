package dev.mandevilla.motivation.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import dev.mandevilla.motivation.infra.SharedPreferencesConstants
import dev.mandevilla.motivation.R
import dev.mandevilla.motivation.databinding.ActivityMainBinding
import dev.mandevilla.motivation.entity.PhraseType
import dev.mandevilla.motivation.repository.phrases.MockPhrasesRepository
import dev.mandevilla.motivation.repository.phrases.interfaces.PhrasesRepository
import dev.mandevilla.motivation.service.SharedPreferencesService

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private var phraseOption: PhraseType? = null
    private val phrasesRepository: PhrasesRepository = MockPhrasesRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initializeActions()
    }

    override fun onResume() {
        loadUserName()
        super.onResume()
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            binding.imageButtonAll.id,
            binding.imageButtonHappy.id,
            binding.imageButtonSunny.id -> handleFilterOptions(view)
            binding.textUserName.id -> handleSetUsername()
            binding.buttonNewPhrase.id -> handleNewPhrase()
        }
    }

    private fun initializeActions() {
        setOnClickListenerComponents()
        handleFilterOptions(binding.imageButtonAll)
    }

    private fun setOnClickListenerComponents() {
        binding.imageButtonAll.setOnClickListener(this)
        binding.imageButtonHappy.setOnClickListener(this)
        binding.imageButtonSunny.setOnClickListener(this)
        binding.textUserName.setOnClickListener(this)
        binding.buttonNewPhrase.setOnClickListener(this)
    }

    private fun handleFilterOptions(view: View?) {
        if (view == null)
            return

        val activeColor = ContextCompat.getColor(this, R.color.white)
        val inactiveColor = ContextCompat.getColor(this, R.color.eggplant_purple)

        var phraseType: PhraseType? = null

        val options = listOf(
            binding.imageButtonAll,
            binding.imageButtonHappy,
            binding.imageButtonSunny
        )

        for (option in options.withIndex()) {
            with(option) {
                val color: Int

                if (value.id == view.id) {
                    color = activeColor
                    phraseType = PhraseType.getById(index)
                } else {
                    color = inactiveColor
                }

                value.setColorFilter(color)
            }
        }

        if (phraseType != phraseOption) {
            phraseOption = phraseType
            handleNewPhrase()
        }
    }

    private fun handleSetUsername() {
        goToUserActivity()
    }

    private fun handleNewPhrase() {
        val phrase = phrasesRepository.getPhrase(phraseOption)
        binding.textPhrase.text = phrase.text
    }

    private fun loadUserName() {
        val hello = getString(R.string.hello)
        val userName = getUserNameFromPreferences() ?: getString(R.string.user).lowercase()

        val valueToShow = "$hello, $userName!"
        binding.textUserName.text = valueToShow
    }

    private fun getUserNameFromPreferences(): String? {
        with(SharedPreferencesService(this)) {
            return getString(SharedPreferencesConstants.Keys.USER_NAME)
        }
    }

    private fun goToUserActivity() =
        navigateTo(UserActivity::class.java)

    private fun <T> navigateTo(activity: Class<T>) {
        with(Intent(this, activity)) {
            startActivity(this)
        }
    }
}
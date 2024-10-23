package dev.mandevilla.motivation.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import dev.mandevilla.motivation.business.UserBusiness
import dev.mandevilla.motivation.business.enums.UserValidateResult
import dev.mandevilla.motivation.constants.SharedPreferencesConstants
import dev.mandevilla.motivation.R
import dev.mandevilla.motivation.databinding.ActivityUserBinding
import dev.mandevilla.motivation.entity.User
import dev.mandevilla.motivation.services.SharedPreferencesService

class UserActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityUserBinding
    private val userBusiness = UserBusiness()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setOnClickListenerComponents()
        handleIfUserNameHasBeenInfomed()
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            binding.buttonSave.id -> handleSave()
        }
    }

    private fun setOnClickListenerComponents() {
        binding.buttonSave.setOnClickListener(this)
    }

    private fun handleIfUserNameHasBeenInfomed() {
        val userName = getUserNameFromPreferences()

        if (userName != null)
            goToMainActivity()
    }

    private fun handleSave() {
        val userName = binding.editUserName.text.toString().trim()
        val user = User(userName)

        if (!validateUser(user))
            return
        else
            closeKeyboard()

        saveUserOnPreferences(user)
        goToMainActivity()
    }

    private fun validateUser(user: User): Boolean {
        val validateResult = userBusiness.validate(user)

        if (validateResult == UserValidateResult.Valid)
            return true

        val errorMessageResourceId = when (validateResult) {
            UserValidateResult.InvalidName -> R.string.insert_a_invalid_user_name
            else -> R.string.unknown_field_validation
        }

        showToast(errorMessageResourceId)
        return false
    }

    private fun goToMainActivity() =
        navigateToAndReplacement(MainActivity::class.java)

    private fun <T> navigateToAndReplacement(activity: Class<T>) {
        with(Intent(this, activity)) {
            startActivity(this)
        }
        finish()
    }

    private fun showToast(resourceId: Int) =
        Toast.makeText(this, resourceId, Toast.LENGTH_SHORT).show()

    private fun closeKeyboard() {
        val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager

        with(inputMethodManager) {
            if (isActive)
                hideSoftInputFromWindow(
                    currentFocus?.windowToken,
                    InputMethodManager.HIDE_NOT_ALWAYS
                )
        }
    }

    private fun getUserNameFromPreferences(): String? {
        with(SharedPreferencesService(this)) {
            return getString(SharedPreferencesConstants.Keys.USER_NAME)
        }
    }

    private fun saveUserOnPreferences(user: User) {
        with(SharedPreferencesService(this)) {
            setString(SharedPreferencesConstants.Keys.USER_NAME, user.name)
        }
    }
}
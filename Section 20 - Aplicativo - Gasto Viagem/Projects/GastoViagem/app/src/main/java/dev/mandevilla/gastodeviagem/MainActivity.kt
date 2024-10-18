package dev.mandevilla.gastodeviagem

import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import business.TravelCostBusiness
import business.enums.TravelCostValidateResult
import dev.mandevilla.gastodeviagem.databinding.ActivityMainBinding
import entity.TravelCost
import utilities.formats.FormatUtilities


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private val travelCostBusiness = TravelCostBusiness()

    // Função responsável por fazer a criação da Activity.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.buttonCalculate.setOnClickListener(this)
    }

    // Função responsável por tratar qualquer evento de click nos elementos.
    override fun onClick(view: View) {
        when (view.id) {
            binding.buttonCalculate.id -> calculate()
        }
    }

    private fun calculate() {
        try {
            val distance = binding.editTextDistance.text.toString().toFloatOrNull()
            val price = binding.editTextPrice.text.toString().toFloatOrNull()
            val autonomy = binding.editTextAutonomy.text.toString().toFloatOrNull()

            val travelCost = TravelCost(distance, price, autonomy)

            if (!validateFields(travelCost))
                return

            val costResultValue = travelCostBusiness.calculate(travelCost)
            val costResult = formatCurrency(costResultValue)

            binding.textViewCostResult.text = costResult
        } finally {
            closeKeyboard()
            unfocusAllFields()
        }
    }

    private fun validateFields(travelCost: TravelCost): Boolean {
        val validateResult = travelCostBusiness.validate(travelCost)

        if (validateResult == TravelCostValidateResult.Valid)
            return true

        val errorMessageResourceId = when (validateResult) {
            TravelCostValidateResult.IncompleteFields -> R.string.incomplete_fields
            TravelCostValidateResult.AutonomyIsZero -> R.string.autonomy_is_zero
            else -> R.string.unknown_error
        }

        showToast(errorMessageResourceId)
        return false
    }

    private fun showToast(resourceId: Int) =
        Toast.makeText(this, resourceId, Toast.LENGTH_SHORT).show()

    private fun formatCurrency(value: Float) =
        FormatUtilities.Currency.format("R$", value)

    private fun closeKeyboard() {
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager

        if (imm.isActive)
            imm.hideSoftInputFromWindow(currentFocus?.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
    }

    private fun unfocusAllFields() {
        with(binding) {
            val fields = arrayOf(editTextDistance, editTextPrice, editTextAutonomy)

            fields.forEach {
                if (it.isFocusable)
                    it.clearFocus()
            }
        }
    }
}
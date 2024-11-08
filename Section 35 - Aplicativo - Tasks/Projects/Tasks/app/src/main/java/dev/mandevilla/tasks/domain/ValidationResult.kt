package dev.mandevilla.tasks.domain

class ValidationResult private constructor(
    val success: Boolean,
    val message: String? = null
) {
    companion object {
        fun getSuccess(): ValidationResult {
            return ValidationResult(true)
        }

        fun getFailure(message: String): ValidationResult {
            return ValidationResult(false, message)
        }
    }
}
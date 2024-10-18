package utilities.formats

internal class FormatUtilities private constructor() {
    object Currency {
        fun format(currencyCode: String, value: Float): String {
            val valueFormated = "%.2f".format(value)
            return "$currencyCode $valueFormated"
        }
    }
}
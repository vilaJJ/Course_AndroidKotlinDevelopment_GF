package control

internal class Console private constructor() {
    companion object {
        fun readString(message: String): String {
            return readInput(message)
        }

        fun readUByte(message: String): UByte {
            try {
                val input = readInput(message)
                return input.toUByte()
            } catch (e: NumberFormatException) {
                throw NumberFormatException("O formato do texto informado é inválido para conversão.")
            }
        }

        private fun readInput(message: String): String {
            print("$message: ")
            val input = readlnOrNull() ?: throw NullPointerException("O valor inserido pelo usuário é nulo.")

            return input
        }
    }
}
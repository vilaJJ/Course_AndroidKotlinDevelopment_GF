class Matematica {
    companion object {
        init {
            println("Companion object inicializado...")
        }

        const val PI = 3.1415

        fun somar(vararg numeros: Int): Int {
            var soma = 0

            for (numero in numeros) {
                soma += numero
            }

            return soma
        }
    }

    object Constantes {
        const val ZERO = 0
    }
}

fun main() {
    println("Valor de PI: ${Matematica.PI}")
    println("Valor de zero: ${Matematica.Constantes.ZERO}")
    println("Soma dos valores: ${Matematica.somar(15, 36, 25, -15, 6)}")
}
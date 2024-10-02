package controleFor

// 4. Faça a soma de todos os números no intervalo de 1 a 500.

fun main() {
    var soma = 0

    for (i in 1..500) {
        soma += i
    }

    println("Resultado da soma: $soma.")
}
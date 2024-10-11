fun main() {
    val mediaAritmetica = calcularMediaAritmetica(5.9f, 7.8f, 9.1f, 8.3f)
    println("Média aritmética: $mediaAritmetica.")

    apresentarDados("Juan Felipe Alves Flores", 2004, 20, true, null, 'M')
}

fun calcularMediaAritmetica(vararg valores: Float): Float {
    var somaValores = 0f

    for (valor in valores) {
        somaValores += valor
    }

    return somaValores / valores.size
}

// Generics

fun <T> apresentarDados(vararg valores: T) {
    for ((index, value) in valores.withIndex()) {
        println("[$index]: $value")
    }
}

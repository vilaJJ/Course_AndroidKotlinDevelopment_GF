import Utils.*

fun main() {
    val leitura1 = realizarLeitura("Insira o primeiro número:")
    val leitura2 = realizarLeitura("Insira o segundo número:")

    val numero1 = converterParaInteiro(leitura1)
    val numero2 = converterParaInteiro(leitura2)

    if (numero1 == null || numero2 == null) {
        println("Os valores informados são inválidos.")
        return
    }

    val isQuadrado = isQuadrado(numero1, numero2)

    val resultado = when (isQuadrado) {
        true -> "É um quadrado, os lados são iguais."
        false -> "Não é um quadrado, lados diferentes."
    }

    println("\n$resultado")
}

fun isQuadrado(lado1 : Number, lado2: Number) = lado1 == lado2
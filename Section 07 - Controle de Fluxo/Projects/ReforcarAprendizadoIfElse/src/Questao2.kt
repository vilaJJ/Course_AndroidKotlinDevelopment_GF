import Utils.*

fun main() {
    val leitura1 = realizarLeitura("Insira o primeiro valor:")
    val leitura2 = realizarLeitura("Insira o segundo valor:")
    val leitura3 = realizarLeitura("Insira o terceiro valor:")

    val numero1 = converterParaInteiro(leitura1)
    val numero2 = converterParaInteiro(leitura2)
    val numero3 = converterParaInteiro(leitura3)

    if (numero1 == null || numero2 == null || numero3 == null) {
        println("Valores inválidos apresentados.")
        return
    }

    val isEquilatero = isEquilatero(numero1, numero2, numero3)

    val resultado = when (isEquilatero) {
        true -> "É um triângulo equilátero, os lados são iguais."
        false -> "Não é um triângulo equilátero, os lados são diferentes."
    }

    println("\n$resultado")
}

fun isEquilatero(lado1: Number, lado2: Number, lado3: Number) =
    lado1 == lado2 && lado2 == lado3
fun main() {
    helloWorld()
    apresentarUsuario("Juan Felipe")

    val resultadoSoma = somar(7, 9)
    println("O resultado da soma é $resultadoSoma.")

    val resultadoMultiplicacao = multiplicar(5f, 7f)
    println("O resultado da multiplicação é $resultadoMultiplicacao.")
}

fun helloWorld() {
    println("Olá, mundo!")
}

fun somar(value1 : Int, value2 : Int) : Int {
    return (value1 + value2)
}

fun multiplicar(value1 : Float, value2 : Float) =
    value1 * value2

fun apresentarUsuario(nome : String) =
    println("Olá, $nome.")
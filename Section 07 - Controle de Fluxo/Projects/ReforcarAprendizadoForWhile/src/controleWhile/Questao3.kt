package controleWhile

/*
3. Escreva um programa capaz de receber um texto e imprimí-lo invertido.

Entrada: Meu nome é Juan.               Saída: .nauJ é emon ueM
*/

fun main() {
    print("Insira um texto: ")
    val textoLeitura = readlnOrNull()

    if (textoLeitura.isNullOrBlank()) {
        println("O texto informado não é válido.")
        return
    }

    var index = textoLeitura.lastIndex
    var textoInvertido = ""

    while (index >= 0) {
        textoInvertido += textoLeitura[index]
        index--
    }

    println("Texto invertido: $textoInvertido")
}
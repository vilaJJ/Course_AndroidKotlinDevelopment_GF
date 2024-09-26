fun main() {
    val texto = "Bárbara Ohana Santos Silva"
    val textoComEspacos = "      Olá, mundo!!     "
    val quantidadeCaracteres = texto.length
    val primeiroCaractere = texto[0]
    val comecaComB = texto.startsWith('b', true)
    val terminaComNA = texto.endsWith("NA")
    val pedacoTexto1 = texto.substring(14)
    val pedacoTexto2 = texto.substring(8, 13)
    val textoAlterado = texto.replace("Silva", "Flores")
    val textoMinusculo = texto.lowercase()
    val textoMaiusculo = texto.uppercase()
    val textoComEspacosCortados = textoComEspacos.trim()
    val textoComEspacosIniciaisCortados = textoComEspacos.trimStart()
    val textoComEspacosFinaisCortados = textoComEspacos.trimEnd()

    println(texto)
    println("Quantidade de caracteres: $quantidadeCaracteres.")
    println("Primeiro caractere (index 0): $primeiroCaractere.")
    println("Começa com 'b': $comecaComB.")
    println("Termina com 'NA': $terminaComNA.")
    println("Pedaço 1 do texto: $pedacoTexto1.")
    println("Pedaço 2 do texto: $pedacoTexto2.")
    println("Texto alterado: $textoAlterado")
    println("Texto minúsculo: $textoMinusculo")
    println("Texto maiúsculo: $textoMaiusculo")
    println("Texto com espaços: >$textoComEspacos<")
    println("Texto com espaços cortados: >$textoComEspacosCortados<")
    println("Texto com espaços iniciais: >$textoComEspacosIniciaisCortados<")
    println("Texto com espaços finais: >$textoComEspacosFinaisCortados<")
}
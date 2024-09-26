package funcoes

/*
* 1. Escreva uma função que seja capaz de receber a quantidade de anos e transformar em meses, dias, horas, minutos e segundos. Saída desejada:
*
* 2 anos equivalem à:
*   24 meses
*   730 dias
*   17520 horas
*   1051200 minutos
*   63072000 segundos
* */
fun detalharQuantidadeAnos(anos: UInt) {
    val meses = anos * 12u
    val dias = anos * 365u
    val horas = dias * 24u
    val minutos = horas * 60u
    val segundos = minutos * 60u

    println("$anos ${if (anos == 1u) "ano equivale" else "anos equivalem"} à:")
    println("\t$meses meses")
    println("\t$dias dias")
    println("\t$horas horas")
    println("\t$minutos minutos")
    println("\t$segundos segundos")
}

// 2. Escreva uma função capaz de receber uma string e retornar a quantidade de caracteres.
fun obterQuantidadeCaracteres(str: String) =
    (str.length)

// 3. Escreva uma função capaz de calcular o cubo de um número inteiro (cubo = n * n * n).
fun calcularCubo(valor: Int) =
    (valor * valor * valor)

// 4. Escreva uma função capaz de receber milhas e converter em km (1 milha = 1,6km).
fun converterMilhasParaKm(milhas: Float) =
    (milhas * 1.6f)

/*
* 5. Escreva um programa que seja capaz de receber uma string e fazer a troca de todas as letras "a" ou "A" por "x".
*   a. Não deve existir lógica dentro da função main. Deve ser usada somente como ponto de entrada.
*   b. Escrever uma função para a troca de letras e impressão do valor final.
*   c. String final deve estar com todas as letras minúsculas.
* */
fun exibirTextoTrocadandoAporX(str: String) {
    var newStr: String = str.replace('a', 'x', true)
    newStr = newStr.lowercase()

    println(newStr)
}
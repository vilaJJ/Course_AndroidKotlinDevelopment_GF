package controleWhile

/*
4. Escreva uma função que recebe uma string, verifica se existe a mesma quantidade de caracteres 'x' e 'o' e retorna
true ou false. Caso não exista nem 'x' nem 'o', retornar false.

"xxooox"    -> true
"xxxxo"     -> false
"bdefghjij" -> false
"ooooxzzzz" -> false
*/

fun main() {
    val str1 = "xxooox"
    val str2 = "xxxxo"
    val str3 = "bdefghjij"
    val str4 = "ooooxzzzz"

    val case1 = verificarString(str1)
    val case2 = verificarString(str2)
    val case3 = verificarString(str3)
    val case4 = verificarString(str4)

    println("Caso 1: $case1")
    println("Caso 2: $case2")
    println("Caso 3: $case3")
    println("Caso 4: $case4")
}

fun verificarString(str: String): Boolean {
    val value = str.lowercase()
    var index = str.lastIndex

    var quantidadeX = 0
    var quantidadeO = 0

    while (index >= 0) {
        val char = value[index]

        when (char) {
            'x' -> quantidadeX++
            'o' -> quantidadeO++
        }

        index--
    }

    return if (quantidadeX == 0 && quantidadeO == 0) {
        false
    } else {
        quantidadeX == quantidadeO
    }
}
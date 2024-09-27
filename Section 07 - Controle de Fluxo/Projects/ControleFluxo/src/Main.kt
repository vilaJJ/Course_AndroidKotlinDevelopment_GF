fun main() {
    verificarIdade(20u)
    verificarIdade(17u)
    verificarIdade(34u)
    verificarIdade(1u)
    verificarIdade(64u)
    verificarIdade(13u)
    verificarIdade(8u)

    println(realizarSaudacao(false))
    println(realizarSaudacao(true))
}

fun verificarIdade(idade: UByte) {
    if (idade < 3u) {
        println("É um bebê.")
    } else if (idade < 13u) {
        println("É uma criança.")
    } else if (idade < 15u) {
        println("É um pré-adolescente.")
    } else if (idade < 18u) {
        println("É um adolescente.")
    } else if (idade < 25u) {
        println("É um jovem adulto")
    } else if (idade < 60u) {
        println("É um adulto.")
    } else {
        println("É um idoso.")
    }
}

fun realizarSaudacao(isDia: Boolean) = if (isDia) {
    "Bom dia."
} else {
    "Boa noite."
}
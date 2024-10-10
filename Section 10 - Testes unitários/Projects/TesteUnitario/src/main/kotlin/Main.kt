package org.example

fun main() {
    println(countXO("xoxo"))
    println(countXO("oxxox"))
    println(countXO("xooxxoxoxoxo"))
}

fun countXO(str: String): Boolean {
    val strLower = str.lowercase()

    var i = 0
    var countX = 0
    var countO = 0

    while (i < strLower.length) {
        if (strLower[i] == 'x')
            countX++
        else
            countO++

        i++
    }

    return countO == countX && countO != 0
}

fun realizarContagem() =
    countXO("xxoxoo")

fun estourarExcecao(): Boolean {
    throw NullPointerException("Valor nulo.")
}

fun apresentarMomentoDoDia(hora: UByte): String {
    val momento = when (hora) {
        in 0u..6u -> "Madrugada"
        in 6u..12u -> "Manhã"
        in 12u..18u -> "Tarde"
        else -> "Noite"
    }

    println("Momento do dia: $momento")
    return momento
}
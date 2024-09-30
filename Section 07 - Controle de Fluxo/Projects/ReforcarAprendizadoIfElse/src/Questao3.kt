fun main() {
    qualSaida(4) // -> Segunda saída
}

fun qualSaida(num: Int) {
    if (num >= 0) {
        if (num == 0)
            println("Primeira saída")
        else
            println("Segunda saída")
    }
    else {
        println("Terceira saída")
    }
}
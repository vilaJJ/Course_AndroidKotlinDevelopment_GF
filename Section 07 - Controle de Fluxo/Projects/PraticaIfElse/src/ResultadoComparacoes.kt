fun main() {
    val a = false
    val b = false
    val c = true
    val d = true

    // (a && b && c && d) -> false
    val comparacao1 = (a && b && c && d)

    // (!a && !b && (c && d)) -> true
    val comparacao2 = (!a && !b && (c && d))

    // (a && ((b || c) || d)) -> false
    val comparacao3 = (a && ((b || c) || d))

    // (a || ((!b && c) || !d)) -> true
    val comparacao4 = (a || ((!b && c) || d))

    println("Resultado da comparação 1: $comparacao1")
    println("Resultado da comparação 2: $comparacao2")
    println("Resultado da comparação 3: $comparacao3")
    println("Resultado da comparação 4: $comparacao4")
}


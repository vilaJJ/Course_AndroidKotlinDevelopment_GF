fun main() {
    // +    -   *   /   %

    var idade = 30

    idade += 2
    idade -= 4
    idade *= 6
    idade /= 8

    println("Idade: $idade")
    println("idade++: ${idade++}")
    println("++idade: ${++idade}")
    println("idade--: ${idade--}")
    println("--idade: ${--idade}")
    println("Idade: $idade")

    val restoDivisao : Float = 10f % 3f
    println("Resto da divisão: $restoDivisao")
}
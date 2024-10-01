fun main() {
    var i = 0

    while (i < 100) {
        println("Verdadeiro ($i)")
        i++
    }

    var j = 100

    while (j > 0) {
        println("Verdadeiro ($j)")
        j--
    }

    var nome = "Juan Felipe"

    while (nome.isNotEmpty()) {
        println(nome)
        nome = nome.removeRange(nome.length - 1, nome.length)
    }
}
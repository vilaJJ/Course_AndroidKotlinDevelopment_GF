fun main() {
    var i = 0

    do {
        println("Valor $i")
        i++
    } while (i in 1..10)

    do {
        print("Infome seu nome: ")
        val nome = readlnOrNull()
    } while (nome != null && nome.isEmpty())
}
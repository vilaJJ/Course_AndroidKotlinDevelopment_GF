fun main() {
    // Null safety
    print("Digite algo: ")
    val nome = readlnOrNull()

    println(nome?.length)
    println(nome!!.length)
}
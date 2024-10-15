// Lista de forma ordenada e podendo repetir dados

fun main() {
    val numeros: List<Int> = listOf(5, 8, 3, 1, 9, 7, 1, 0, 2, 4, 6)
    val listaMutavel: MutableList<String> = mutableListOf("Juan", "Bárbara")

    with(numeros) {
        apresentarLista(this)
    }

    with(listaMutavel) {
        listaMutavel.add("Maria")
        listaMutavel.remove("Juan")
        listaMutavel.removeAt(1)

        println("Lista contêm 'Bárbara': ${contains("Bárbara")}")

        apresentarLista(this)
        clear()
        apresentarLista(this)
    }
}

private fun apresentarLista(lista: List<Any>) {
    println("\nQuantidade de itens na lista: ${lista.size}")

    for ((index, item) in lista.withIndex()) {
        println("\t[$index] = $item")
    }
}
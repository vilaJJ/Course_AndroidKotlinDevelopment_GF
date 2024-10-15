// Valores não ordenados e não duplicados.

fun main() {
    val set = setOf("Tocantins", "Pará", "Maranhão", "Bahia")
    val mutableSet = mutableSetOf<String>()

    println(set)

    with(mutableSet) {
        add("Brasil")
        add("Argentina")
        add("Uruguai")

        remove("Argentina")

        println(this)
        println("Quantidade de itens: $size")

        clear()

        println(this)
    }
}
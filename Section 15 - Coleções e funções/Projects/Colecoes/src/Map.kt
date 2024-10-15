// Coleção de chave e valor, funciona em pares.

fun main() {
    val map: Map<Int, String> =
        mapOf(
            Pair(11, "São Paulo"),
            Pair(21, "Rio de Janeiro"),
            Pair(62, "Goais"),
            Pair(63, "Tocantins")
        )
    val mutableMap = mutableMapOf<String, String>(Pair("MT", "Metros"), Pair("CM", "Centimetros"))

    apresentarDDDs(map)

    with(mutableMap) {
        this["KM/h"] = "Kilometros por hora"
        this["MM"] = "Milimetros"
        this["L"] = "Litro"
        this["ML"] = "Mililitros"

        this["L"] = "Litros"

        println(mutableMap)
        println("Map contêm 'ML': ${contains("ML")}")
        println("Quantidade de itens: $size")
    }
}

private fun apresentarDDDs(ddds: Map<Int, String>) {
    for (ddd in ddds) {
        with(ddd) {
            println("DDD $key de $value")
        }
    }
}
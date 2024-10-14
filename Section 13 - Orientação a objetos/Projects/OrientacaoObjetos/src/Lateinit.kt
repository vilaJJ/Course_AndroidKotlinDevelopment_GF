class Receita {
    lateinit var instrucoes: String

    fun gerar() {
        instrucoes = "Lave as mãos."
    }

    fun imprimir() {
        val dadosImprimir = if (this::instrucoes.isInitialized) instrucoes else "Receita não gerada."
        println(dadosImprimir)
    }
}

fun main() {
    val receita = Receita()

    with(receita) {
        imprimir()
        gerar()

        println(receita.instrucoes)
    }
}
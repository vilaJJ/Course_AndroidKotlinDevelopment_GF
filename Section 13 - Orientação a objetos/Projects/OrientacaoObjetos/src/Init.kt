class Animal(val especie: String) {
    var fala: String = ""
        get() {
            println("Acesso get")
            return field
        }
        set(value) {
            println("Acesso set")
            field = value
        }

    init {
        println("Classe Animal instanciada (Init 1)")
    }
    init {
        fala = when (especie) {
            "Cachorro" -> "Auau"
            "Gato" -> "Miau"
            else -> "Fala não especificada"
        }

        println("Operações de inicialização executadas (Init 2)")
    }

    fun falar() {
        println(fala)
    }
}

fun main() {
    val cachorro = Animal(especie = "Cachorro")
    cachorro.fala = "Auuuuu";
    cachorro.falar()

    Animal(especie = "Gato").falar()
}
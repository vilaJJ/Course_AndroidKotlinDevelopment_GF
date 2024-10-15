abstract class Animal(val nome: String) {
    abstract fun acordar()
    abstract fun dormir()
}

interface Selvagem {
    fun atacar(animalAlvo: Animal)
}

abstract class Mamifero(nome: String) : Animal(nome) {
    override fun acordar() {
        println("$nome acordou...")
    }

    override fun dormir() {
        println("$nome dormiu...")
    }

    abstract fun apresentar()
    abstract fun falar()
}

class Lobo(nome: String) : Mamifero(nome), Selvagem {
    override fun apresentar() {
        println("Lobo $nome")
    }

    override fun falar() {
        println("Auuuuuuuuuuuuuuuuuuuuuuuu")
    }

    override fun atacar(animalAlvo: Animal) {
        println("$nome atacou ${animalAlvo.nome}...")
    }
}

class Gato(nome: String) : Mamifero(nome) {
    override fun apresentar() {
        println("Gato $nome")
    }

    override fun falar() {
        println("Miau")
    }
}

fun main() {
    val mamifero1: Mamifero = Lobo("Marron")
    val mamifero2: Mamifero = Gato("Garfield")

    usarMamifero(mamifero1)
    usarMamifero(mamifero2)

    val lobo1: Selvagem = Lobo("Milobo")
    lobo1.atacar(mamifero2)
}

private fun usarMamifero(mamifero: Mamifero) {
    println("$mamifero\n")

    with(mamifero) {
        apresentar()
        falar()
    }

    escreverLinha()
}

private fun escreverLinha() {
    println("------------------------------------------")
}


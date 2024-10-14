fun main() {
    val classe: Classe

    // Instanciação da classe
    val pessoa = Pessoa(nome = "Juan Felipe", anoNascimento = 2004u, nacionalidade = "Brasileiro")

    println("Nome: ${pessoa.nome}")
    println("Ano de nascimento: ${pessoa.anoNascimento}")
    println("Nacionalidade: ${pessoa.nacionalidade}")

    pessoa.acordar()
    pessoa.dormir()

    pessoa.peso = 83.6f
}

// Classe vazia
// Construtor primário privado
class Classe private constructor()

// Classe gera objetos
// Classe com construtor primário
class Pessoa(val nome: String, val anoNascimento: UShort) {
    // Construtores

    constructor(nome: String, anoNascimento: UShort, nacionalidade: String) : this(nome, anoNascimento) {
        this.nacionalidade = nacionalidade
    }

    // Atributos

    var nacionalidade: String? = null
    var peso: Float? = null

    // Comportamentos

    fun acordar() {
        println("$nome acordou...")
    }

    fun dormir() {
        println("$nome dormiu...")
    }
}
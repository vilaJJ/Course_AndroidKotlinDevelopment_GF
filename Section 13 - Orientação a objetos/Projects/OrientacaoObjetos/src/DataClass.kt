fun main() {
    val forma1 = FormaData(10, 8)
    val forma2 = FormaData(10, 8)

    println(forma1.toString())
    println(forma1.hashCode())

    println("-------------------------------")

    println(forma2.toString())
    println(forma2.hashCode())

    println("-------------------------------")

    println(forma1.equals(forma2))

    println("-------------------------------")

    val endereco = Endereco(
        rua = "Rua do Chambari",
        numero = 150u,
        cep = "77860-480",
        cidade = "Araguaína",
        estado = "Tocantins",
        pais = "Brasil"
    )
    apresentarEndereco(endereco)

    val enderecoCopia = endereco.copy(numero = 280u)
    apresentarEndereco(enderecoCopia)
}

class Forma(val a: Int, val b: Int) {
    override fun equals(other: Any?): Boolean {
        return if (other is Forma) {
            (other.a == this.a && other.b == this.b)
        } else {
            false
        }
    }

    override fun toString(): String {
        return "Forma (a = $a, b = $b)"
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }
}

data class FormaData(val a: Int, val b: Int)

data class Endereco(
    val rua: String,
    val numero: UInt,
    val cep: String,
    val cidade: String,
    val estado: String,
    val pais: String
)

fun apresentarEndereco(endereco: Endereco) {
    println(endereco)
}
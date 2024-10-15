abstract class Pessoa(val nome: String)

abstract class Funcionario(nome: String) : Pessoa(nome) {
    abstract val salario: Float
    abstract fun calcularBonus(): Float
}

class Gerente(nome: String, override val salario: Float) : Funcionario(nome) {
    override fun calcularBonus(): Float =
        salario * .3f
}

class Analista(nome: String, override val salario: Float) : Funcionario(nome) {
    override fun calcularBonus(): Float =
        salario * .15f
}

private fun exibirBonus(funcionario: Funcionario) {
    with(funcionario) {
        val tipo = this::class.simpleName
        val bonus = calcularBonus()

        println("O $tipo $nome terá um bônus de R$ $bonus.")
    }
}

fun main() {
    val gerente = Gerente(nome = "Bárbara Ohana", salario = 5634f)
    val analista = Analista(nome = "Juan Felipe", salario = 4286f)

    exibirBonus(gerente)
    exibirBonus(analista)
}
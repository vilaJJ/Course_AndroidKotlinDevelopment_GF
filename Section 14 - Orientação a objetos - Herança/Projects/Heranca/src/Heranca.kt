open class Eletronico(val marca: String) {
    protected var isLigado: Boolean = false
        private set

    private fun alterarCorrente(isLigado: Boolean) {
        this.isLigado = isLigado

        val status = if (isLigado) "ativada" else "desativada"
        println("Corrente do $marca $status.")
    }

    open fun ligar() {
        println("$marca ligando...")
        alterarCorrente(isLigado = true)
    }

    open fun desligar() {
        println("$marca desligando...")
        alterarCorrente(isLigado = false)
    }
}

internal class Computador(marca: String) : Eletronico(marca) {
    override fun desligar() {
        salvarDados()
        super.desligar()
    }

    fun acessarBios() {
        if (!isLigado) {
            println("Não é possível acessar a BIOS com o computador desligado.")
            return
        }

        println("Acessando a BIOS do $marca...")
    }

    fun salvarDados() {
        println("Dados do $marca salvos.")
    }

    fun <T> salvarDados(vararg dados: T) {
        println("Iniciando salvamento de dados no $marca...")

        for (dado in dados) {
            if (dado == null)
                continue

            println("\tDado '$dado' salvo...")
        }

        salvarDados()
    }
}

fun main() {
    val computador1 = Computador("Dell")

    with(computador1) {
        acessarBios()
        ligar()
        salvarDados()
        acessarBios()
        salvarDados("Juan", "Bárbara", null, 16, true, 'D')
        desligar()
    }

    val eletronico: Eletronico = Computador("Lenovo")

    eletronico.run {
        ligar()
        desligar()
    }
}
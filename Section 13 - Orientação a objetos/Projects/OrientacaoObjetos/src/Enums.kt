enum class Prioridade(val horaMaximaPermitida: UInt) {
    Baixa(horaMaximaPermitida = 1u),
    Media(horaMaximaPermitida = 3u) {
        override fun toString(): String {
            return "Média"
        }
    },
    Alta(horaMaximaPermitida = 5u),
    Urgente(horaMaximaPermitida = 24u);

    fun exibirDetalhes(): String {
        val textoHoraMaximaPermitida = if (horaMaximaPermitida == 1u) "hora" else "horas"
        return "A prioridade $this permite atvidades de até $horaMaximaPermitida $textoHoraMaximaPermitida"
    }
}

fun realizarAtividade(prioridade: Prioridade) {
    println("Executando atividade de prioridade $prioridade")
}

fun exibirDetalhesPrioridades() {
    println("Exibindo os tipos de prioridades:")

    for (prioridade in Prioridade.entries) {
        println(prioridade.exibirDetalhes())
    }
}

fun main() {
    realizarAtividade(Prioridade.Alta)
    realizarAtividade(Prioridade.Baixa)
    realizarAtividade(Prioridade.Media)
    realizarAtividade(Prioridade.Urgente)

    exibirDetalhesPrioridades()
}
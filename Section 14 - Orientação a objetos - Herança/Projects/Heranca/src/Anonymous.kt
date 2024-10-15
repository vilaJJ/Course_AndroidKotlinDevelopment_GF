interface Event {
    fun onSuccess()
}

class Programa {
    fun salvar(e: Event) {
        println("Abrindo conexões...")
        println("Salvando valores...")
        println("Sucesso. Conexões fechadas.")
        e.onSuccess()
    }
}

fun main() {
    val programa = Programa()
    programa.salvar(object: Event {
        override fun onSuccess() {
            println("Evento finalizado com sesco")
        }
    })
}
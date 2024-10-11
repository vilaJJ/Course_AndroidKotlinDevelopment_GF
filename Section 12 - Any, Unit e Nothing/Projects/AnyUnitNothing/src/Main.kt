fun main() {
    // Any: os demais tipos de dados herdam de Any
    apresentarValor("Juan Felipe Alves Flores")
    apresentarValor(2004)
    apresentarValor(false)
    apresentarValor(1.84f)
    apresentarValor('M')

    // Unit: não possui retorno (semelhante ao void do Java)

    // Nothing: utilizada para retornar exceções
    // Utilizado bastante em métodos e propriedades não implementadas, na implementação de interfaces.
    salvar()
}

fun apresentarValor(value: Any) {
    println("Valor: $value")
}

fun salvar(): Nothing {
    TODO("Não implementado ainda.")
}
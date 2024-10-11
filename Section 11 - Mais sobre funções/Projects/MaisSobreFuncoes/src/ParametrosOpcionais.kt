fun main() {
    apresentarEndereco("Rua São João", "Araguaína", "Tocantins", "77404-800")
    apresentarEndereco(estado = "Tocantins", cidade = "Araguaína", rua = "Rua dos Papagaios")
}

fun apresentarEndereco(rua: String, cidade: String, estado: String, cep: String? = null, numero: UByte? = null) {
    println("Rua: $rua\n" +
            "Cidade: $cidade\n" +
            "Estado: $estado\n" +
            "CEP: ${cep ?: "Não informado"}\n" +
            "Número: ${numero ?: "S/N"}\n")
}
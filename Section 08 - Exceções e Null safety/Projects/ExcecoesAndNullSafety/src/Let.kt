fun main() {
    print("Digite algo: ")
    var texto: String? = readlnOrNull()

    if (texto?.length == 0) {
        texto = null
    }

    texto?.let {
        println("Tamanho do texto: ${it.length}")
    }
}
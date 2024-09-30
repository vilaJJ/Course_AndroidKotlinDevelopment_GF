package Utils

fun realizarLeitura(textoApresentar: String) : String? {
    print("$textoApresentar ")
    return readlnOrNull()
}

fun converterParaInteiro(value: String?) = value?.toInt()
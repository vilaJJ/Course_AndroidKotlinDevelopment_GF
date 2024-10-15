package org.example.utils

internal fun realizarLeitura(textoApresentar: String) : String? {
    print("$textoApresentar ")
    return readlnOrNull()
}

internal fun converterParaInteiro(value: String?) = value?.toInt()
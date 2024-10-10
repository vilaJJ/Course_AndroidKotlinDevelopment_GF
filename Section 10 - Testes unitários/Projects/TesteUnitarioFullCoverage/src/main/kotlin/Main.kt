fun realizarPortaria(idade: UByte, tipoConviteId: Int, conviteCode: String): Boolean {
    if (idade < 18u) {
        println("Negado. Menores de idade não são permitidos.")
        return false
    }

    val isTipoConviteValido = isTipoConviteValido(tipoConviteId)

    if (!isTipoConviteValido) {
        println("Negado. Convite inválido.")
        return false
    }

    val isCodigoConviteValido = isCodigoConviteValido(tipoConviteId, conviteCode)

    if (!isCodigoConviteValido) {
        println("Negado. Código de convite inválido.")
        return false
    }

    println("Welcome :)")
    return true
}

fun isTipoConviteValido(tipoConviteId: Int) = tipoConviteId in 1..3

fun isCodigoConviteValido(tipoConviteId: Int, conviteCode: String): Boolean {
    val codigoInicial = conviteCode.substring(0, 2).uppercase()

    return if (tipoConviteId == 1 && codigoInicial == "XT")
        true
    else if (tipoConviteId in 2..3 && codigoInicial == "XL")
        true
    else
        false
}
import utils.converterParaInteiro
import utils.realizarLeitura

fun main() {
    val idadeLeitura = realizarLeitura("Insira a sua idade:")
    val idade = converterParaInteiro(idadeLeitura)

    if (idade == null) {
        println("O valor da idade informada é inválido.")
        return
    }
    if (idade < 18) {
        println("Negado. Menores de idade não são permitidos.")
        return
    }

    val tipoConviteLeitura = realizarLeitura(
        "Insira o seu tipo de convite\n" +
                "\t1 -> Comum\n" +
                "\t2 -> Premium\n" +
                "\t3 -> Luxo\n" +
                "Insira o código:"
    )
    val tipoConvite = converterParaInteiro(tipoConviteLeitura)

    if (tipoConvite == null) {
        println("O valor do tipo de convite informado é inválido.")
        return
    }

    val isTipoConviteValido = isTipoConviteValido(tipoConvite)

    if (!isTipoConviteValido) {
        println("Negado. Convite inválido.")
        return
    }

    val codigoConviteLeitura = realizarLeitura("Insira o código do convite:")

    if (codigoConviteLeitura == null) {
        println("O valor do código do convite informado é inválido.")
        return
    }

    val isCodigoConviteValido = isCodigoConviteValido(tipoConvite, codigoConviteLeitura)

    if (!isCodigoConviteValido) {
        println("Negado. Código de convite inválido.")
        return
    }

    println("Welcome :)")
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
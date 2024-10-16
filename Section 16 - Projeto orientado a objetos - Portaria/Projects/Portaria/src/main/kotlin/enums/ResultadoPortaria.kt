package enums

internal enum class ResultadoPortaria {
    Permitido,
    ConvidadoInvalido,
    MenorIdade,
    TipoConviteInvalido,
    CodigoConviteInvalido,
    DadosInvalidos;

    override fun toString(): String {
        return when(this) {
            Permitido -> "Entrada permitida."
            ConvidadoInvalido -> "O convidado não está apto a entrar."
            MenorIdade -> "Menores de idade não são permitidos."
            TipoConviteInvalido -> "O tipo de convite é inválido."
            CodigoConviteInvalido -> "O código do convite é inválido."
            DadosInvalidos -> "Os dados informados à portaria são inválidos."
        }
    }
}
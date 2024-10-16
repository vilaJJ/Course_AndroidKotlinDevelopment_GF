package business

import entity.Pessoa
import enums.ValidacaoConvidado

internal class ConvidadoBusiness {
    internal fun validar(pessoa: Pessoa): ValidacaoConvidado {
        with(pessoa) {
            if (!validarIdade(idade))
                return ValidacaoConvidado.MenorIdade
        }

        return ValidacaoConvidado.Valido
    }

    private fun validarIdade(idade: UByte) = idade >= 18u
}
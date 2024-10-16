package control

import business.ConviteBusiness
import business.ConvidadoBusiness
import business.TipoConviteBusiness
import entity.Convite
import entity.Pessoa
import enums.ResultadoPortaria
import enums.TipoConvite
import enums.ValidacaoConvidado

internal class Portaria private constructor() {
    private val convidadoBusiness = ConvidadoBusiness()
    private val conviteBusiness = ConviteBusiness()
    private val tipoConviteBusiness = TipoConviteBusiness()

    companion object {
        internal fun iniciar(): ResultadoPortaria {
            with(Portaria()) {
                try {
                    val idade: UByte = Console.readUByte("Informe a sua idade")
                    val validacaoConvidado = convidadoBusiness.validar(Pessoa(idade))

                    if (validacaoConvidado != ValidacaoConvidado.Valido)
                        return ResultadoPortaria.ConvidadoInvalido

                    val tipoConviteId = Console.readUByte(
                        "Insira o seu tipo de convite\n" +
                                "\t1 -> Comum\n" +
                                "\t2 -> Premium\n" +
                                "\t3 -> Luxo\n" +
                                "Insira o código"
                    )

                    val tipoConvite = TipoConvite.obter(tipoConviteId)
                    val isTipoConviteValido = tipoConviteBusiness.validar(tipoConvite)

                    if (!isTipoConviteValido)
                        return ResultadoPortaria.TipoConviteInvalido

                    val conviteCodigo = Console.readString("Insira o código do convite")
                    val isConviteCodigoValido = conviteBusiness.validar(
                        Convite(
                            tipoConvite!!,
                            conviteCodigo,
                        )
                    )

                    if (!isConviteCodigoValido)
                        return ResultadoPortaria.CodigoConviteInvalido

                    return ResultadoPortaria.Permitido
                } catch (e: Exception) {
                    println(e.message)
                    return ResultadoPortaria.DadosInvalidos
                }
            }
        }
    }
}
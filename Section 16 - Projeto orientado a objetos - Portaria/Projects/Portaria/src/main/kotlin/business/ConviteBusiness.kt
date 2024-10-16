package business

import entity.Convite

internal class ConviteBusiness {
    internal fun validar(convite: Convite): Boolean {
        with(convite) {
            val prefixoCodigo = obterPrefixoCodigo(codigo)
            return tipo.prefixo.equals(prefixoCodigo, true)
        }
    }

    private fun obterPrefixoCodigo(codigo: String) =
        codigo.substring(0, 2)
}
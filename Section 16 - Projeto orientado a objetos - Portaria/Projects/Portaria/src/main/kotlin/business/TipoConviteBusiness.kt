package business

import enums.TipoConvite

internal class TipoConviteBusiness {
    internal fun validar(tipo: TipoConvite?) =
        TipoConvite.entries.contains(tipo)
}
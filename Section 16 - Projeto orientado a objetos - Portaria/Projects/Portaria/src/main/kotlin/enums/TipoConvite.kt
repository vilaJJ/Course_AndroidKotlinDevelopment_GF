package enums

internal enum class TipoConvite(private val id: UByte, val prefixo: String) {
    Comum(1u, "XT"),
    Premium(2u, "XL"),
    Luxo(3u, "XL");

    companion object {
        internal fun obter(id: UByte): TipoConvite? {
            return entries.firstOrNull { it.id == id }
        }
    }
}
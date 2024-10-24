package dev.mandevilla.motivation.entity.languages

internal enum class Languages(val tag: String) {
    English("en"),
    French("fr"),
    Portuguese("pt");

    companion object {
        fun getByRegionTag(tag: String) =
            Languages.entries.firstOrNull { it.tag == tag }
    }
}
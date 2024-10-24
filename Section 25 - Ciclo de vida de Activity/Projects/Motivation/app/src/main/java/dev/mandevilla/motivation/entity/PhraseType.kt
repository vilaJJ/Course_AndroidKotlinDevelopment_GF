package dev.mandevilla.motivation.entity

internal enum class PhraseType(val id: Int) {
    All(0),
    Happy(1),
    Sunny(2);

    companion object {
        fun getById(id: Int): PhraseType? =
            PhraseType.entries.firstOrNull { it.id == id }
    }
}
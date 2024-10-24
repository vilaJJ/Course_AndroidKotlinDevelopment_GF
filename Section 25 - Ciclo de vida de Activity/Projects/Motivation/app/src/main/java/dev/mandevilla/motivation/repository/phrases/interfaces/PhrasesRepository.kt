package dev.mandevilla.motivation.repository.phrases.interfaces

import dev.mandevilla.motivation.entity.Phrase
import dev.mandevilla.motivation.entity.PhraseType

internal interface PhrasesRepository {
    fun getPhrase(phraseType: PhraseType?): Phrase
}
package dev.mandevilla.motivation.repository.phrases.interfaces

import dev.mandevilla.motivation.entity.languages.Languages
import dev.mandevilla.motivation.entity.phrase.Phrase
import dev.mandevilla.motivation.entity.phrase.PhraseType

internal interface PhrasesRepository {
    fun getPhrase(phraseType: PhraseType?, language: Languages): Phrase
}
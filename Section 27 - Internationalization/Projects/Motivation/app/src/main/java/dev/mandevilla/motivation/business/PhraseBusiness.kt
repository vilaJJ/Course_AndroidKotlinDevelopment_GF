package dev.mandevilla.motivation.business

import dev.mandevilla.motivation.entity.languages.Languages
import dev.mandevilla.motivation.entity.phrase.PhraseType
import dev.mandevilla.motivation.repository.phrases.MockPhrasesRepository
import dev.mandevilla.motivation.repository.phrases.interfaces.PhrasesRepository
import java.util.Locale

internal class PhraseBusiness {
    companion object {
        private val defaultPhraseLanguage = Languages.Portuguese
    }

    private val repository: PhrasesRepository = MockPhrasesRepository()

    fun getPhrase(type: PhraseType?): String? {
        val locale = Locale.getDefault()
        val language = Languages.getByRegionTag(locale.language) ?: defaultPhraseLanguage
        val phrase = repository.getPhrase(type, language)

        return phrase.text;
    }
}
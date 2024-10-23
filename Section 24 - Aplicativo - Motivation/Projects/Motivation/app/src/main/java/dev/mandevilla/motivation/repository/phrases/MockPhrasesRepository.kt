package dev.mandevilla.motivation.repository.phrases

import dev.mandevilla.motivation.entity.Phrase
import dev.mandevilla.motivation.entity.PhraseType
import dev.mandevilla.motivation.repository.phrases.interfaces.PhrasesRepository
import kotlin.random.Random

internal class MockPhrasesRepository : PhrasesRepository {
    private val list = listOf(
        Phrase(
            PhraseType.Happy,
            "Não sabendo que era impossível, foi lá e fez."
        ),
        Phrase(
            PhraseType.Happy,
            "Você não é derrotado quando perde, você é derrotado quando desiste!"
        ),
        Phrase(
            PhraseType.Happy,
            "Quando está mais escuro, vemos mais estrelas!"
        ),
        Phrase(
            PhraseType.Happy,
            "Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente."
        ),
        Phrase(
            PhraseType.Happy,
            "Não pare quando estiver cansado, pare quando tiver terminado."
        ),
        Phrase(
            PhraseType.Happy,
            "O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?"
        ),
        Phrase(
            PhraseType.Sunny,
            "A melhor maneira de prever o futuro é inventá-lo."
        ),
        Phrase(
            PhraseType.Sunny,
            "Você perde todas as chances que você não aproveita."
        ),
        Phrase(
            PhraseType.Sunny,
            "Enquanto não estivermos comprometidos, haverá hesitação!"
        ),
        Phrase(
            PhraseType.Sunny,
            "Se você não sabe onde quer ir, qualquer caminho serve."
        ),
        Phrase(
            PhraseType.Sunny,
            "Se você acredita, faz toda a diferença."
        ),
        Phrase(
            PhraseType.Sunny,
            "Riscos devem ser corridos, porque o maior perigo é não arriscar nada!"
        )
    )

    override fun getPhrase(phraseType: PhraseType?): Phrase {
        val type = phraseType ?: PhraseType.All

        val phrasesFiltered = list.filter { type == PhraseType.All || it.type == type }
        val randomIndex = Random.nextInt(phrasesFiltered.size)
        return phrasesFiltered[randomIndex]
    }
}
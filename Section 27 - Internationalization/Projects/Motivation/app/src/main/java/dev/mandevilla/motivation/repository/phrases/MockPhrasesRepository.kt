package dev.mandevilla.motivation.repository.phrases

import dev.mandevilla.motivation.entity.languages.Languages
import dev.mandevilla.motivation.entity.phrase.Phrase
import dev.mandevilla.motivation.entity.phrase.PhraseData
import dev.mandevilla.motivation.entity.phrase.PhraseType
import dev.mandevilla.motivation.entity.languages.TextLanguages
import dev.mandevilla.motivation.repository.phrases.interfaces.PhrasesRepository
import kotlin.random.Random

internal class MockPhrasesRepository : PhrasesRepository {
    private val list = listOf(
        PhraseData(
            PhraseType.Happy,
            TextLanguages(
                mapOf(
                    Pair(
                        Languages.English,
                        "Not knowing it was impossible, he went ahead and did it."
                    ),
                    Pair(
                        Languages.French,
                        "Ne sachant pas que c'était impossible, il s'y est rendu et l'a fait."
                    ),
                    Pair(
                        Languages.Portuguese,
                        "Não sabendo que era impossível, foi lá e fez."
                    )
                )
            )
        ),
        PhraseData(
            PhraseType.Happy,
            TextLanguages(
                mapOf(
                    Pair(
                        Languages.English,
                        "You are not defeated when you lose, you are defeated when you give up!"
                    ),
                    Pair(
                        Languages.French,
                        "Vous n’êtes pas vaincu lorsque vous perdez, vous êtes vaincu lorsque vous abandonnez !"
                    ),
                    Pair(
                        Languages.Portuguese,
                        "Você não é derrotado quando perde, você é derrotado quando desiste!"
                    )
                )
            )
        ),
        PhraseData(
            PhraseType.Happy,
            TextLanguages(
                mapOf(
                    Pair(
                        Languages.English,
                        "When it's darker, we see more stars!"
                    ),
                    Pair(
                        Languages.French,
                        "Quand il fait plus sombre, on voit plus d’étoiles !"
                    ),
                    Pair(
                        Languages.Portuguese,
                        "Quando está mais escuro, vemos mais estrelas!"
                    )
                )
            )
        ),
        PhraseData(
            PhraseType.Happy,
            TextLanguages(
                mapOf(
                    Pair(
                        Languages.English,
                        "Insanity is doing the same thing over and over again and expecting a different result."
                    ),
                    Pair(
                        Languages.French,
                        "La folie, c'est faire la même chose encore et encore et s'attendre à un résultat différent."
                    ),
                    Pair(
                        Languages.Portuguese,
                        "Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente."
                    )
                )
            )
        ),
        PhraseData(
            PhraseType.Happy,
            TextLanguages(
                mapOf(
                    Pair(
                        Languages.English,
                        "Don't stop when you're tired, stop when you're done."
                    ),
                    Pair(
                        Languages.French,
                        "Ne vous arrêtez pas lorsque vous êtes fatigué, arrêtez-vous lorsque vous avez terminé."
                    ),
                    Pair(
                        Languages.Portuguese,
                        "Não pare quando estiver cansado, pare quando tiver terminado."
                    )
                )
            )
        ),
        PhraseData(
            PhraseType.Happy,
            TextLanguages(
                mapOf(
                    Pair(
                        Languages.English,
                        "What can you do right now that will have the biggest impact on your success?"
                    ),
                    Pair(
                        Languages.French,
                        "Que pouvez-vous faire dès maintenant pour avoir le plus grand impact sur votre réussite ?"
                    ),
                    Pair(
                        Languages.Portuguese,
                        "O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?"
                    )
                )
            )
        ),
        PhraseData(
            PhraseType.Sunny,
            TextLanguages(
                mapOf(
                    Pair(
                        Languages.English,
                        "The best way to predict the future is to invent it."
                    ),
                    Pair(
                        Languages.French,
                        "La meilleure façon de prédire l’avenir est de l’inventer."
                    ),
                    Pair(
                        Languages.Portuguese,
                        "A melhor maneira de prever o futuro é inventá-lo."
                    )
                )
            )
        ),
        PhraseData(
            PhraseType.Sunny,
            TextLanguages(
                mapOf(
                    Pair(
                        Languages.English,
                        "You miss every chance you don't take."
                    ),
                    Pair(
                        Languages.French,
                        "Vous perdez toutes les chances que vous ne saisissez pas."
                    ),
                    Pair(
                        Languages.Portuguese,
                        "Você perde todas as chances que você não aproveita."
                    )
                )
            )
        ),
        PhraseData(
            PhraseType.Sunny,
            TextLanguages(
                mapOf(
                    Pair(
                        Languages.English,
                        "Until we are committed, there will be hesitation!"
                    ),
                    Pair(
                        Languages.French,
                        "Tant que nous ne nous engageons pas, il y aura des hésitations !"
                    ),
                    Pair(
                        Languages.Portuguese,
                        "Enquanto não estivermos comprometidos, haverá hesitação!"
                    )
                )
            )
        ),
        PhraseData(
            PhraseType.Sunny,
            TextLanguages(
                mapOf(
                    Pair(
                        Languages.English,
                        "If you don't know where you want to go, any road will do."
                    ),
                    Pair(
                        Languages.French,
                        "Si vous ne savez pas où vous voulez aller, n’importe quel chemin fera l’affaire."
                    ),
                    Pair(
                        Languages.Portuguese,
                        "Se você não sabe onde quer ir, qualquer caminho serve."
                    )
                )
            )
        ),
        PhraseData(
            PhraseType.Sunny,
            TextLanguages(
                mapOf(
                    Pair(
                        Languages.English,
                        "If you believe, it makes all the difference."
                    ),
                    Pair(
                        Languages.French,
                        "Si vous y croyez, cela fait toute la différence."
                    ),
                    Pair(
                        Languages.Portuguese,
                        "Se você acredita, faz toda a diferença."
                    )
                )
            )
        ),
        PhraseData(
            PhraseType.Sunny,
            TextLanguages(
                mapOf(
                    Pair(
                        Languages.English,
                        "Risks must be taken, because the greatest danger is not risking anything!"
                    ),
                    Pair(
                        Languages.French,
                        "Il faut prendre des risques, car le plus grand danger est de ne rien risquer !"
                    ),
                    Pair(
                        Languages.Portuguese,
                        "Riscos devem ser corridos, porque o maior perigo é não arriscar nada!"
                    )
                )
            )
        )
    )

    override fun getPhrase(phraseType: PhraseType?, language: Languages): Phrase {
        val type = phraseType ?: PhraseType.All

        val phrasesFiltered = list.filter { type == PhraseType.All || it.type == type }
        val randomIndex = Random.nextInt(phrasesFiltered.size)

        with(phrasesFiltered[randomIndex]) {
            return Phrase(type, texts.getBy(language))
        }
    }
}
package dev.mandevilla.motivation.entity.languages

internal class TextLanguages(private val values: Map<Languages, String>) {
    fun getBy(language: Languages) = values[language]
}
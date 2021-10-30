package com.sectordefectuoso.domino.model.enum

enum class QuestionTypeEnum(val id: Int, val es: String) {
    MULTI(1, "Multiopcion"),
    BINARY(2, "Binario");

    companion object {
        private val map = values().associate { it.id to it.es }
        fun mapAll() = map
    }
}
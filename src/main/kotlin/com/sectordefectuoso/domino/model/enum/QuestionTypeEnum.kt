package com.sectordefectuoso.domino.model.enum

enum class QuestionTypeEnum(val id: Int, val valueEs: String) {
    MULTI(1, "Multiopcion"),
    BINARY(2, "Binario");

    companion object {
        private val map = values().associate { it.id to it.valueEs }
        fun mapAll() = map
    }
}
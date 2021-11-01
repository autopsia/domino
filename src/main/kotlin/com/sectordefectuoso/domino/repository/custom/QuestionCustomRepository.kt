package com.sectordefectuoso.domino.repository.custom

import org.springframework.data.mongodb.core.MongoTemplate

open class QuestionCustomRepository(
    private val mongoTemplate: MongoTemplate
) {
}
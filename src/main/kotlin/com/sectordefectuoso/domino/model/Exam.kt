package com.sectordefectuoso.domino.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("exams")
data class Exam(
    @Id
    var id: Long,
    var value: String,
    var score: Int,
    var questions: List<Question>,
)
package com.sectordefectuoso.domino.model

import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

import java.time.LocalDateTime.now

//Esta clase almacena las respuestas del usuario al examen
@Document("userAnswers")
data class UserAnswer (
    val question: ObjectId?,
    val dateCreated: LocalDateTime = now()
)
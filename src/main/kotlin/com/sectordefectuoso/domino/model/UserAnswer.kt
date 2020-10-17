package com.sectordefectuoso.domino.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

//Esta clase almacena las respuestas del usuario al examen
@Document("userAnswers")
data class UserAnswer(
        @Id
        var id: ObjectId,
)
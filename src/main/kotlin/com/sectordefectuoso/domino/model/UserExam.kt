package com.sectordefectuoso.domino.model

import com.mongodb.DBRef
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

//Esta tabla contiene todos los examenes del usuario como ids de referencia
@Document("userExams")
data class UserExam(
        @Id
        var id: ObjectId,
        var user: String,
        var exams: List<DBRef>,
)
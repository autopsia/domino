package com.sectordefectuoso.domino.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("questions")
data class Question(
    @Id
    var id: ObjectId,
    var dateCreated: Long,
    var answers: List<Answer>,
) {

}
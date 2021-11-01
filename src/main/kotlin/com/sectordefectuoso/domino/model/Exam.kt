package com.sectordefectuoso.domino.model

import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer
import com.sectordefectuoso.domino.user.model.User
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

@Document("exams")
data class Exam(
    @Id @JsonSerialize(using = ToStringSerializer::class)
    var id: ObjectId? = null,
    var userIssuer: ObjectId, //ObjectID O USERNAME?
    @DBRef
    var participants: Set<User>, //lista de usuarios?
    var questions: List<Question>,
)
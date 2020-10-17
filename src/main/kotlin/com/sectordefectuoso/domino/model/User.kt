package com.sectordefectuoso.domino.model

import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("users")
data class User(
    @Id @JsonSerialize(using = ToStringSerializer::class)
    var id: ObjectId,
    var username: String,
    var password: String,
    var type: String,
    var dateCreated: Long,
) {
}
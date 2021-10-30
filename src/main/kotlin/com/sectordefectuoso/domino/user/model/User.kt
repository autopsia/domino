package com.sectordefectuoso.domino.user.model

import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer
import com.sectordefectuoso.domino.utils.timestampNow
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime
import java.time.LocalDateTime.now
import java.util.Collections.emptySet

@Document("users")
data class User(
    @Id @JsonSerialize(using = ToStringSerializer::class)
    var id: ObjectId? = null,
    var email: String,
    var username: String,
    var password: String,
    var roles: Set<String> = emptySet(),
    var firstName: String?,
    var lastName: String?,
    var ins: LocalDateTime = now(),
    var upd: LocalDateTime = now(),
)
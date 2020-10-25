package com.sectordefectuoso.domino.model

import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document("questions")
data class Question(
    @Id @JsonSerialize(using = ToStringSerializer::class)
    var id: ObjectId,
    var dateCreated: LocalDateTime,
    var category: String, //categoria cursos
    var tags: String,
    var difficulty: Int, //dificultad depoendiendo del grado
    var language: String,
    var author: String, //usuario autor
    var heading: String, //enunciado
    var private: Boolean,
    var type: Int, //tipo de pregunta, multiopcion, si o no, detallada, completa las palabras

    // podria ser un objecto   nuevo, dependiendo del tipo de pregunta
    var answers: List<Answer>, //respuesta correcta
    var options: List<Option>, // opciones para responder
) {

}
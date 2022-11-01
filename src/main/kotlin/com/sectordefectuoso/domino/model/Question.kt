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
    var id: ObjectId?,
    var cats: Set<String>, //categoria cursos
    var tags: Set<String>, // etiquetas
    var diff: Int, //dificultad depoendiendo del grado
    var lang: String, // es, en, us
    var author: String, //usuario autor
    var heading: String, //enunciado
    var privacy: Int,
    var type: Int, //tipo de pregunta, multiopcion, si o no, detallada, completa las palabras

    // podria ser un objecto   nuevo, dependiendo del tipo de pregunta
    var answers: Set<Answer>, //respuesta correcta
    var options: Set<Option>, // opciones para responder

    //Fechas
    val ins: LocalDateTime = LocalDateTime.now(),
    var upd: LocalDateTime = LocalDateTime.now(),

) {

}
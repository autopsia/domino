package com.sectordefectuoso.domino.model.dto

import com.sectordefectuoso.domino.model.Answer
import com.sectordefectuoso.domino.model.Option
import com.sectordefectuoso.domino.model.Question

data class QuestionInsReq (
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
)

fun QuestionInsReq.toQuestion() = Question(
    id = null,
    cats = cats,
    tags = tags,
    diff = diff,
    lang = lang,
    author = author,
    heading = heading,
    privacy = privacy,
    type = type,
    options = options,
    answers = answers,
)

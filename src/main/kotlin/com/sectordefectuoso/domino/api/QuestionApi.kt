package com.sectordefectuoso.domino.api

import com.sectordefectuoso.domino.model.Question
import com.sectordefectuoso.domino.model.enum.QuestionTypeEnum
import com.sectordefectuoso.domino.service.QuestionService
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/questions")
class QuestionApi (
    private val questionService: QuestionService,
){

    @GetMapping()
    fun getAllQuestions(): Flux<Question> {
        return questionService.findAll()
    }

    @PostMapping()
    fun insertQuestion(
        @RequestBody question: Question
    ): Mono<Question> {
        val a = 123
        a.toString().length

        val i: Int? = "9646324351".toIntOrNull(0)
        val t: Int = "21".toIntOrNull() ?: 0

        Math.abs(1)


        return questionService.insert(question)
    }
}
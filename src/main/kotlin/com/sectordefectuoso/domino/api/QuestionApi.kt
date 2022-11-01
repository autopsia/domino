package com.sectordefectuoso.domino.api

import com.sectordefectuoso.domino.model.Question
import com.sectordefectuoso.domino.model.dto.QuestionInsReq
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
        @RequestBody question: QuestionInsReq
    ): Mono<Question> {
        return questionService.insert(question)
    }

    @DeleteMapping("/{id}")
    fun deleteQuestion(@PathVariable(value = "id") id: String) {
        questionService.delete(id)
    }
}
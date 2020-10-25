package com.sectordefectuoso.domino.api

import com.sectordefectuoso.domino.model.Question
import com.sectordefectuoso.domino.service.QuestionService
import com.sectordefectuoso.domino.utils.epochNow
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/questions")
class QuestionApi(
    val questionService: QuestionService,
) {
    @GetMapping()
    fun getAllQuestions() : ResponseEntity<*> {
        val foundQuestions = questionService.findAll()
        return ResponseEntity(foundQuestions, HttpStatus.OK)
    }

    @PostMapping()
    fun insertQuestion(@RequestBody question: Question) : ResponseEntity<*> {
        val newQuestion = questionService.insert(question)
        return ResponseEntity(newQuestion, HttpStatus.CREATED)
    }

    @GetMapping("/test")
    fun datetest() : ResponseEntity<*> {
        return ResponseEntity(epochNow(), HttpStatus.OK)
    }
}
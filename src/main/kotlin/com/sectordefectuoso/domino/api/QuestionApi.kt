package com.sectordefectuoso.domino.api

import com.sectordefectuoso.domino.model.Question
import com.sectordefectuoso.domino.service.QuestionService
import com.sectordefectuoso.domino.utils.timeStampNow
import io.swagger.annotations.ApiImplicitParam
import io.swagger.annotations.ApiImplicitParams
import io.swagger.annotations.Example
import io.swagger.annotations.ExampleProperty
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

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
        return ResponseEntity(timeStampNow(), HttpStatus.OK)
    }
}
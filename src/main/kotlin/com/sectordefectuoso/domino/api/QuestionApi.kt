package com.sectordefectuoso.domino.api

import com.sectordefectuoso.domino.service.QuestionService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/question")
class QuestionApi(
    val questionService: QuestionService,
) {

}
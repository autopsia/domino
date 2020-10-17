package com.sectordefectuoso.domino.api

import com.sectordefectuoso.domino.model.enum.QuestionTypeEnum
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UtilApi {
    @GetMapping("/util")
    fun getQuestionTypes(): Array<QuestionTypeEnum> {
        return QuestionTypeEnum.values()
    }
}
package com.sectordefectuoso.domino.api

import com.fasterxml.jackson.databind.util.EnumValues
import com.sectordefectuoso.domino.model.enum.QuestionTypeEnum
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class UtilApi {
    @GetMapping("/util")
    fun getQuestionTypes(): Map<Int, String> {
        return QuestionTypeEnum.mapAll()
    }
}
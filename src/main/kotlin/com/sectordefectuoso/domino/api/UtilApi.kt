package com.sectordefectuoso.domino.api

import com.fasterxml.jackson.databind.util.EnumValues
import com.sectordefectuoso.domino.model.enum.QuestionTypeEnum
import com.sectordefectuoso.domino.model.enum.RoleEnum
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/util")
class UtilApi {
    @GetMapping("/question/types")
    fun getQuestionTypes(): Map<Int, String> {
        return QuestionTypeEnum.mapAll()
    }

    @GetMapping("/roles")
    fun getRoles(): Map<Int, String> {
        return RoleEnum.mapAll()
    }
}
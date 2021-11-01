package com.sectordefectuoso.domino.api

import com.fasterxml.jackson.databind.util.EnumValues
import com.sectordefectuoso.domino.model.Question
import com.sectordefectuoso.domino.model.UserAnswer
import com.sectordefectuoso.domino.model.enum.QuestionTypeEnum
import com.sectordefectuoso.domino.model.enum.RoleEnum
import com.sectordefectuoso.domino.user.model.User
import org.bson.types.ObjectId
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration
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

    @GetMapping("test")
    fun test(): Mono<Any>{
        return Mono.just(UserAnswer(null))

    }

    @GetMapping("flux",
        produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun testFlux(): Flux<UserAnswer>{
        return Flux.interval(Duration.ofSeconds(1))
            .log("info")
            .map { UserAnswer(null) }

    }
}
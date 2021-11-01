package com.sectordefectuoso.domino.service

import com.sectordefectuoso.domino.model.Question
import com.sectordefectuoso.domino.repository.QuestionRepository
import org.bson.types.ObjectId
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.LocalDateTime

@Service
class QuestionService(
    private val questionRepository: QuestionRepository,
) {
    fun findAll(): Flux<Question> {
        return questionRepository.findAll()
    }

    fun insert(question: Question): Mono<Question> {
        return questionRepository.insert(question)
    }

    fun delete(id: String): Mono<Void> {
        return questionRepository.deleteById(ObjectId(id))
    }

    fun findById(id: String): Mono<Question>{
        return questionRepository.findById(id)
    }
}
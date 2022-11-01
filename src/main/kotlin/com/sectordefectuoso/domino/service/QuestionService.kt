package com.sectordefectuoso.domino.service

import com.sectordefectuoso.domino.model.Question
import com.sectordefectuoso.domino.model.dto.QuestionInsReq
import com.sectordefectuoso.domino.model.dto.toQuestion
import com.sectordefectuoso.domino.repository.QuestionRepository
import org.bson.types.ObjectId
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class QuestionService(
    private val questionRepository: QuestionRepository,
) {
    fun findAll(): Flux<Question> {
        return questionRepository.findAll()
    }

    fun insert(questionDto: QuestionInsReq): Mono<Question> {
        return questionRepository.insert(questionDto.toQuestion())
    }

    fun delete(id: String): Mono<Void> {
        return questionRepository.deleteById(ObjectId(id))
    }

    fun findById(id: String): Mono<Question>{
        return questionRepository.findById(id)
    }

    fun getRandomQuestions(category: String, size: Long): Flux<Question> {
        return questionRepository.findRandom(category, size)
    }
}
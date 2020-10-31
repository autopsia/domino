package com.sectordefectuoso.domino.service

import com.sectordefectuoso.domino.model.Question
import com.sectordefectuoso.domino.repository.QuestionRepository
import org.bson.types.ObjectId
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class QuestionService(
    val questionRepository: QuestionRepository,
) {
    fun findAll(): List<Question>? {
        return questionRepository.findAll()
    }

    fun insert(question: Question): Question? {
        question.dateCreated = LocalDateTime.now()
        return questionRepository.insert(question)
    }

    fun delete(id: String){
        return questionRepository.deleteById(ObjectId(id))
    }
}
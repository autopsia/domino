package com.sectordefectuoso.domino.service

import com.sectordefectuoso.domino.model.Question
import com.sectordefectuoso.domino.repository.QuestionRepository
import com.sectordefectuoso.domino.utils.timeStampNow
import org.springframework.stereotype.Service

@Service
class QuestionService(
    val questionRepository: QuestionRepository,
) {
    fun findAll(): List<Question>? {
        return questionRepository.findAll()
    }

    fun insert(question: Question): Question? {
        question.dateCreated = timeStampNow()
        return questionRepository.insert(question)
    }
}
package com.sectordefectuoso.domino.service

import com.sectordefectuoso.domino.repository.QuestionRepository
import org.springframework.stereotype.Service

@Service
class QuestionService(
    val questionRepository: QuestionRepository,
) {
}
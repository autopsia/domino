package com.sectordefectuoso.domino.service

import com.sectordefectuoso.domino.model.Exam
import com.sectordefectuoso.domino.model.Question
import com.sectordefectuoso.domino.repository.ExamRepository
import org.bson.types.ObjectId
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class ExamService(
	private val examRepository: ExamRepository,
	private val questionService: QuestionService,
) {

	fun createExamWithRandomQuestions(
		category: String, size: Long, participantIdList: Set<String>, creatorId: ObjectId
	): Mono<Exam> {
		val questionsFlux = questionService.getRandomQuestions(category, size)
		val questions = mutableListOf<Question>()
		questionsFlux.collectList().subscribe(questions::addAll)

		// TODO obtener usuarios participantes por id

		val exam = Exam(
			questions = questions,
			userIssuer = creatorId,
			participants = emptySet()
		)

		return examRepository.save(exam)
	}

}
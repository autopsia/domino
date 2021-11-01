package com.sectordefectuoso.domino.service

import com.sectordefectuoso.domino.model.Exam
import com.sectordefectuoso.domino.model.Question
import com.sectordefectuoso.domino.repository.ExamRepository
import com.sectordefectuoso.domino.user.model.User
import com.sectordefectuoso.domino.user.service.UserService
import org.bson.types.ObjectId
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.lang.Exception

@Service
class ExamService(
	private val examRepository: ExamRepository,
	private val questionService: QuestionService,
	private val userService: UserService,
) {

	fun createExamWithRandomQuestions(
		category: String, size: Long, participantIdList: Set<String>, creatorId: ObjectId
	): Mono<Exam> {
		val questionsFlux = questionService.getRandomQuestions(category, size)
		val questions = mutableListOf<Question>()
		questionsFlux.collectList().subscribe(questions::addAll)

		val usersFlux = userService.findAllByIdList(participantIdList)
		val users = mutableListOf<User>()
		usersFlux.collectList().subscribe(users::addAll)

		if (users.size != participantIdList.size) throw Exception("Not all participants were found")

		val exam = Exam(
			questions = questions,
			userIssuer = creatorId,
			participants = users.toSet()
		)

		return examRepository.save(exam)
	}

}
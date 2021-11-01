package com.sectordefectuoso.domino.api

import com.sectordefectuoso.domino.service.ExamService
import org.bson.types.ObjectId
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/exams")
class ExamApi(
	private val examService: ExamService,
) {

	@PostMapping()
	fun createExamWithRandomQuestions(
		@RequestParam category: String,
		@RequestParam questionCount: Long,
		@RequestBody participantsIdList: Set<String>,
	){
		// TODO Add user data
		val userid = ObjectId("617f6401721ab67b1b4f13ba")

		examService.createExamWithRandomQuestions(category, questionCount, participantsIdList, userid)
	}
}
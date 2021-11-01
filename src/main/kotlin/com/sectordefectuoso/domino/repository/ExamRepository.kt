package com.sectordefectuoso.domino.repository

import com.sectordefectuoso.domino.model.Exam
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ExamRepository: ReactiveMongoRepository<Exam, ObjectId> {
}
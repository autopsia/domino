package com.sectordefectuoso.domino.repository

import com.sectordefectuoso.domino.model.Question
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface QuestionRepository: MongoRepository<Question, ObjectId> {
}
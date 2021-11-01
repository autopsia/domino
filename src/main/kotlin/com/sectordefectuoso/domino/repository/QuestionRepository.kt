package com.sectordefectuoso.domino.repository

import com.sectordefectuoso.domino.model.Question
import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.core.findOne
import org.springframework.data.mongodb.core.query.Query.query
import org.springframework.data.mongodb.core.query.where
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
abstract class QuestionRepository (
    val template: ReactiveMongoTemplate,
) : ReactiveMongoRepository<Question, ObjectId>
{
    fun findById (id: String): Mono<Question> {
        return template.findOne(query(where(Question::id).`is`(id)), "")
    }

}
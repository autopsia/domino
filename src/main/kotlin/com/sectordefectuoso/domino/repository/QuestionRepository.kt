package com.sectordefectuoso.domino.repository

import com.sectordefectuoso.domino.model.Question
import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.core.aggregate
import org.springframework.data.mongodb.core.aggregation.Aggregation
import org.springframework.data.mongodb.core.aggregation.Aggregation.*
import org.springframework.data.mongodb.core.findOne
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Query.query
import org.springframework.data.mongodb.core.query.where
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Repository
abstract class QuestionRepository (
    val template: ReactiveMongoTemplate,
) : ReactiveMongoRepository<Question, ObjectId>
{
    fun findById (id: String): Mono<Question> {
        return template.findOne(query(where(Question::id).`is`(id)), "")
    }

    fun findRandom(category: String, size: Long): Flux<Question> {
        val match = match(where(Question::cats).`is`(category))
        val sample = sample(size)

        val agg = newAggregation(Question::class.java, match, sample)
        return template.aggregate(agg)
    }

}
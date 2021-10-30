package com.sectordefectuoso.domino.user.repository.custom

import com.sectordefectuoso.domino.user.model.req.UserReq
import com.sectordefectuoso.domino.user.model.User
import org.springframework.data.mongodb.core.FindAndModifyOptions.options
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update
import reactor.core.publisher.Mono
import java.time.LocalDateTime.now

class UserRepositoryImpl(
    private val mongoTemplate: ReactiveMongoTemplate
): CustomUserRepository {
    override fun partialUpdate(userReq: UserReq): Mono<User?> {
        val query = Query.query(Criteria.where("username").`is`(userReq.username))
        val update= Update()
            .set("password", userReq.password)
            .set("firstName", userReq.firstName)
            .set("lastName", userReq.lastName)
            .set("dateUpdated", now())
        return mongoTemplate.findAndModify(
            query, update, options().returnNew(true), User::class.java)
    }

}
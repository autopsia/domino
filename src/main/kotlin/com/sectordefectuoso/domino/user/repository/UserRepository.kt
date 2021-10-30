package com.sectordefectuoso.domino.user.repository

import com.sectordefectuoso.domino.user.model.User
import com.sectordefectuoso.domino.user.repository.custom.CustomUserRepository
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
interface UserRepository : ReactiveMongoRepository<User, ObjectId>, CustomUserRepository {
    fun findUserByUsername(username: String): Mono<User?>
}
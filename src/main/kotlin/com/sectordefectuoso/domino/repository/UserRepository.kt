package com.sectordefectuoso.domino.repository

import com.sectordefectuoso.domino.model.User
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : MongoRepository<User, ObjectId> {
    fun findUserByUsername(username: String): User?
}
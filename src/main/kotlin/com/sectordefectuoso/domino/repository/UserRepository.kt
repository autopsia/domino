package com.sectordefectuoso.domino.repository

import com.sectordefectuoso.domino.model.User
import com.sectordefectuoso.domino.repository.custom.user.CustomUserRepository
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : MongoRepository<User, ObjectId>, CustomUserRepository {
    fun findUserByUsername(username: String): User?
}
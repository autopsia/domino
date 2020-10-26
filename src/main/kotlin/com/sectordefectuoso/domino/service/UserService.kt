package com.sectordefectuoso.domino.service

import com.sectordefectuoso.domino.model.User
import com.sectordefectuoso.domino.model.enum.RoleEnum
import com.sectordefectuoso.domino.model.req.UserReq
import com.sectordefectuoso.domino.repository.UserRepository
import com.sectordefectuoso.domino.utils.createAccountRoles
import com.sectordefectuoso.domino.utils.timestampNow
import org.bson.types.ObjectId
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UserService(
        val userRepository: UserRepository,
) {

    fun findAll(): List<User> = userRepository.findAll()

    fun getById(id: ObjectId): User? = userRepository.findByIdOrNull(id)

    fun getByUsername(username: String): User? = userRepository.findUserByUsername(username)

    fun create(userReq: UserReq): User? {
        //filtra los los roles que vienen de frontend a los maximos predefinidos
        userReq.roles = userReq.roles?.filter { it in createAccountRoles }?.toSet()
        userReq.roles = null ?: setOf(RoleEnum.STUDENT.name)

        val user = User(
                email = userReq.email!!,
                username = userReq.username!!,
                password = userReq.password!!,
                roles = userReq.roles,
                dateCreated = timestampNow(),
                dateUpdated = timestampNow(),
        )

        return userRepository.insert(user)
    }

    fun update(userReq: UserReq, username: String): User? {
        val dbUser = userRepository.findUserByUsername(username)!!
        //aqui solo update data que el usuario pueda editar para evitar cambios inesperados
        //userReq.roles = userReq.roles?.distinct()?.toSet()
        userReq.roles = userReq.roles?.filter { it in createAccountRoles }?.toSet()

        dbUser.email = userReq.email ?: dbUser.email
        dbUser.username = userReq.username ?: dbUser.username
        dbUser.password = userReq.password ?: dbUser.password
        dbUser.roles = userReq.roles ?: dbUser.roles
        dbUser.dateUpdated = timestampNow()
        return userRepository.save(dbUser)
    }
}
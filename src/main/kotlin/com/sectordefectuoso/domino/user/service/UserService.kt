package com.sectordefectuoso.domino.user.service

import com.sectordefectuoso.domino.user.model.User
import com.sectordefectuoso.domino.model.enum.RoleEnum
import com.sectordefectuoso.domino.user.model.req.UserReq
import com.sectordefectuoso.domino.user.repository.UserRepository
import com.sectordefectuoso.domino.utils.createAccountRoles
import com.sectordefectuoso.domino.utils.timestampNow
import org.bson.types.ObjectId
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class UserService(
	private val userRepository: UserRepository,
) {

	fun findAll(): Flux<User> = userRepository.findAll()

  fun findAllByIdList(ids: Set<String>): Flux<User> = userRepository.findAllById(ids)

	fun getById(id: ObjectId): Mono<User> = userRepository.findById(id)

	fun getByUsername(username: String): Mono<User?> = userRepository.findUserByUsername(username)

	fun create(userReq: UserReq): Mono<User> {
		//filtra los los roles que vienen de frontend a los maximos predefinidos
		userReq.roles = userReq.roles.filter { it in createAccountRoles }.toSet()
		if (userReq.roles.isEmpty()) userReq.roles = setOf(RoleEnum.STUDENT.name)

		val user = User(
			email = userReq.email!!,
			username = userReq.username!!,
			password = userReq.password!!,
			firstName = userReq.firstName,
			lastName = userReq.lastName,
			roles = userReq.roles,
			ins = timestampNow(),
		)

		return userRepository.insert(user)
	}

	fun update(userReq: UserReq, username: String): Mono<User?> {
		//aqui se validan las cosas
		return userRepository.partialUpdate(userReq)
	}
}
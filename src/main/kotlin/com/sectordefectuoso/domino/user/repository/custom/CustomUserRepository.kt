package com.sectordefectuoso.domino.user.repository.custom

import com.sectordefectuoso.domino.user.model.req.UserReq
import com.sectordefectuoso.domino.user.model.User
import reactor.core.publisher.Mono

interface CustomUserRepository {
    fun partialUpdate(userReq: UserReq): Mono<User?>
}
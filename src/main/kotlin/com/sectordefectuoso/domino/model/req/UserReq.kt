package com.sectordefectuoso.domino.model.req

data class UserReq(
        val email: String?,
        val username: String?,
        val password: String?,
        var roles: Set<String>?,
) {
}
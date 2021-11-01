package com.sectordefectuoso.domino.user.model.req

import java.util.Collections.emptySet

data class UserReq(
        val email: String? = null,
        val username: String? = null,
        val password: String? = null,
        val firstName: String? = null,
        val lastName: String? = null,
        var roles: Set<String> = emptySet(),
) {
}
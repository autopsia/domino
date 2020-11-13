package com.sectordefectuoso.domino.repository.custom.user

import com.sectordefectuoso.domino.model.User

interface CustomUserRepository {
    fun partialUpdate(): User
}
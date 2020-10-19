package com.sectordefectuoso.domino.service

import com.sectordefectuoso.domino.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(val userRepository: UserRepository) {
}
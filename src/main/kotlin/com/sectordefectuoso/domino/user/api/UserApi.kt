package com.sectordefectuoso.domino.user.api

import com.sectordefectuoso.domino.user.model.req.UserReq
import com.sectordefectuoso.domino.user.service.UserService
import com.sectordefectuoso.domino.user.model.User
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/users")
class UserApi (
    private val userService: UserService,
){
    @GetMapping
    fun findAllUsers(): Flux<User> {
        return userService.findAll()
    }

    @GetMapping("/{username}")
    fun getUserByUsername(@PathVariable username: String) : Mono<User?> {
        return userService.getByUsername(username)
    }

    @PostMapping
    fun createUser(@RequestBody user: UserReq) : Mono<User> {
        return userService.create(user)
    }

    @PutMapping("/{username}")
    fun updateUser(@RequestBody user: UserReq, @PathVariable username: String) : Mono<User?> {
        return userService.update(user, username)
    }
}
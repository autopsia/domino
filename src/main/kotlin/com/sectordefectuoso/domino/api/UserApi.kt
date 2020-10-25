package com.sectordefectuoso.domino.api

import com.sectordefectuoso.domino.model.User
import com.sectordefectuoso.domino.model.req.UserReq
import com.sectordefectuoso.domino.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserApi (
        val userService: UserService,
){
    @GetMapping
    fun findAllUsers() : ResponseEntity<*> {
        val users = userService.findAll().ifEmpty {
            return ResponseEntity<Any>(HttpStatus.NOT_FOUND)
        }
        return ResponseEntity(users, HttpStatus.OK)
    }

    @PostMapping
    fun createUser(@RequestBody user: UserReq) : ResponseEntity<*> {
        val userToInsert = userService.create(user) ?: return ResponseEntity<Any>(HttpStatus.BAD_REQUEST)
        return ResponseEntity(userToInsert, HttpStatus.OK)
    }

    @PutMapping("/{username}")
    fun updateUser(@RequestBody user: UserReq, @PathVariable username: String) : ResponseEntity<*> {
        val userToUpdate = userService.update(user, username) ?: return ResponseEntity<Any>(HttpStatus.NOT_FOUND)
        return ResponseEntity(userToUpdate, HttpStatus.OK)
    }
}
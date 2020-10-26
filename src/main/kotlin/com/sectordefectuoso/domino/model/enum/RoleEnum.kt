package com.sectordefectuoso.domino.model.enum

enum class RoleEnum(val id: Int, val valueEs: String) {
    ADMIN(1, "Administrador"),
    STUDENT(2, "Estudiante"),
    INSTRUCTOR(3, "Instructor");

    companion object {
        private val map = values().associate { it.id to it.valueEs }
        fun mapAll() = map
    }
}
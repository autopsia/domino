package com.sectordefectuoso.domino.model.enum

enum class RoleEnum(val id: Int, val en:String, val es: String) {
    ADMIN(1, "Administrator", "Administrador"),
    STUDENT(2, "Student", "Estudiante"),
    INSTRUCTOR(3, "Instructor", "Instructor");

    companion object {
        private val map = values().associate { it.id to it.es }
        fun mapAll() = map
    }
}
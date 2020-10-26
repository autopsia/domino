package com.sectordefectuoso.domino.utils

import com.sectordefectuoso.domino.model.enum.RoleEnum

val createAccountRoles: Set<String> = setOf(RoleEnum.INSTRUCTOR.name, RoleEnum.STUDENT.name)
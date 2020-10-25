package com.sectordefectuoso.domino.utils

import java.time.*

fun epochNow() = Instant.now().toEpochMilli()
fun timestampNow() = LocalDateTime.now()
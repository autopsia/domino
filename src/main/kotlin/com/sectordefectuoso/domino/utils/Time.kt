package com.sectordefectuoso.domino.utils

import java.time.*

fun epochNow(): Long = Instant.now().toEpochMilli()
fun timestampNow(): LocalDateTime = LocalDateTime.now()
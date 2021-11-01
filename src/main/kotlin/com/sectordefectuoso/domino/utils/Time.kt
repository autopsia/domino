package com.sectordefectuoso.domino.utils

import java.time.*

fun epochNow(): Long = Instant.now().toEpochMilli()
fun timestampNow(): LocalDateTime = LocalDateTime.now()

fun intToRoman(num: Int): String {
    val map = linkedMapOf('M' to 1000, 'D' to 500, 'C' to 100, 'L' to 50, 'X' to 10, 'V' to 5, 'I' to 1)
    val list = listOf('M' to 1000, 'D' to 500, 'C' to 100, 'L' to 50, 'X' to 10, 'V' to 5, 'I' to 1)
    val string = StringBuilder()

    var num2 = num

    for ((i, kv) in list.withIndex()){
        if (num2 <= 0) break
        if (num2 < kv.second) continue
        val temp = num2 / kv.second
        if (temp == 4 || temp == 9) {
            string.append(list[i - 1])
            string.append(kv.second)
        } else {
            for (i in 1..temp){
                string.append(kv.first)
            }
        }

        num2 -= kv.second * temp
        println(num2)
    }

    return string.toString()

}
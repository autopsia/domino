package com.sectordefectuoso.domino

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DominoApplication

fun main(args: Array<String>) {
	//TimeZone.setDefault(TimeZone.getTimeZone("UTC"))
	System.setProperty("spring.main.lazy-initialization", "true")
	runApplication<DominoApplication>(*args)
}

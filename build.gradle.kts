import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.7.5"
    id("io.spring.dependency-management") version "1.0.15.RELEASE"
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
}

repositories {
    mavenCentral()
}

dependencies {
//    implementation("org.springframework.boot:spring-boot-starter-data-mongodb:2.5.0")
//    implementation("org.springframework.boot:spring-boot-starter-web:2.5.0")
    //springboot
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb-reactive")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    //springdoc
    implementation("org.springdoc:springdoc-openapi-kotlin:1.6.12")
    implementation("org.springdoc:springdoc-openapi-webflux-ui:1.6.12")
    //kotlin
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.5.30")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.5.30")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    //testing
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
    testImplementation("io.projectreactor:reactor-test")

}

group = "com.sectordefectuoso"
version = "0.0.2"
description = "domino"
java.sourceCompatibility = JavaVersion.VERSION_17

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

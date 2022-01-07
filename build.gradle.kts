import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.10"
    application
}

group = "dev.noirdjinn"
version = "1.3-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}

application {
    mainClass.set("MainKt")
}

task("runDay", JavaExec::class) {
    val year = project.properties["year"] ?: "0"
    val day = project.properties["day"] ?: "0"
    main = "aoc$year.Day${day}Kt"
    classpath = sourceSets["main"].runtimeClasspath
}
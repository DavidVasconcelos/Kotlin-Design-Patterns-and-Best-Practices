import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.0"
}

repositories {
    mavenCentral()
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")

    group = "me.soshin"
    version = "1.0-SNAPSHOT"

    repositories {
        mavenCentral()
    }

    tasks.test {
        useJUnitPlatform()
    }

    tasks.withType<KotlinCompile>() {
        kotlinOptions.jvmTarget = "1.8"
    }
}
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.10"
}
group = "me.alessandro"
version = "1.0"

repositories {
    mavenCentral()
}
dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.4.10")
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}
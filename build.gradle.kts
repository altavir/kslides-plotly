import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    application
    kotlin("jvm") version "1.6.21"
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

application {
    mainClassName = "SlidesKt"
}

// Change this to your group name
group = "com.github.username"
version = "1.1.5"

repositories {
    mavenCentral()
    maven("https://repo.kotlin.link")
    maven("https://jitpack.io")
}

val kotlin_version: String by extra
val ktor_version: String by extra
val kslides_version: String by extra
val css_version: String by extra
val utils_version: String by extra
val logging_version: String by extra
val logback_version: String by extra
val junit_version: String by extra

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version")

    implementation("com.github.kslides.kslides:kslides-core:$kslides_version")

    implementation("space.kscience:plotlykt-core:0.5.1-dev-4")

    implementation("io.ktor:ktor-server:$ktor_version")
    implementation("io.ktor:ktor-server-cio:$ktor_version")
    implementation("io.ktor:ktor-server-sessions:$ktor_version")
    implementation("io.ktor:ktor-server-html-builder:$ktor_version")

    implementation("org.jetbrains.kotlin-wrappers:kotlin-css:$css_version")

    implementation("com.github.pambrose.common-utils:core-utils:$utils_version")
    implementation("com.github.pambrose.common-utils:ktor-server-utils:$utils_version")

    implementation("io.github.microutils:kotlin-logging:$logging_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")

    implementation("junit:junit:$junit_version") // for junit playgrounds
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
    kotlinOptions.freeCompilerArgs = kotlinOptions.freeCompilerArgs +"-Xopt-in=kotlin.RequiresOptIn"
}
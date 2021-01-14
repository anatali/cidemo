import org.jetbrains.kotlin.konan.file.File.Companion.userDir
/*
==============================================================================
This file DOES NOT INCLUDE THE com.palantir.docker PLUGIN
A  docker-related task is defined in the app/buildMaster.gradle.kts
since it requires an AD-HOC Dockerfile
==============================================================================
 */
plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    id("org.jetbrains.kotlin.jvm") version "1.3.72"

    // Apply the application plugin to add support for building a CLI application in Java.
    application

    //Gradle plugins for working with Docker containers
    //id( "com.palantir.docker" ) version "0.25.0"
    //id( "com.palantir.docker-run")  version "0.25.0"
}

repositories {
    // Use JCenter for resolving dependencies.
    jcenter()
    //flatDir {dirs( "C:\\Didattica2018Work\\cidemo\\unibolibs")}
    flatDir {dirs( "file:///${userDir}/unibolibs")}
    //ADDED TO ACCESS the unibo local library. If we use / does not work on ubuntu build
}

dependencies {
    // Align versions of all Kotlin components
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))

    // Use the Kotlin JDK 8 standard library.
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // This dependency is used by the application.
    implementation("com.google.guava:guava:29.0-jre")

    // Use the Kotlin test library.
    testImplementation("org.jetbrains.kotlin:kotlin-test")

    // Use the Kotlin JUnit integration.
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")

    implementation( "tuprolog:2p301" )  //ADDED TO USE the TuProlog library
}

application {
    // Define the main class for the application.
    mainClass.set("cidemo.AppKt")
}

println("userdir= $userDir  project.name=${project.name} mainClass=${application.mainClass.get()}")

//ADDED
tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "cidemo.AppKt"
    }
}


task("hello") {
    doLast {
        println("Hello world from app - this=${this}")
    }
}


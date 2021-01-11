import org.jetbrains.kotlin.konan.file.File.Companion.userDir

/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Kotlin application project to get you started.
 * For more details take a look at the 'Building Java & JVM projects' chapter in the Gradle
 * User Manual available at https://docs.gradle.org/6.7.1/userguide/building_java_projects.html
 */

plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    id("org.jetbrains.kotlin.jvm") version "1.3.72"

    // Apply the application plugin to add support for building a CLI application in Java.
    application
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

println("userdir= $userDir  mainClass=${application.mainClass.get()}")

//ADDED
tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "cidemo.AppKt"
    }
}

//https://www.youtube.com/watch?v=R8_veQiYBjI
//https://www.youtube.com/watch?v=3c-iBn73dDE
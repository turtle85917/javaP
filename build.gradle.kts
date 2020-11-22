plugins {
    java
    kotlin("jvm") version "1.4.10"
}

group = "com.github.pikokr.pbot"
version = "1.0-SNAPSHOT"

repositories {
    jcenter()
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation("junit", "junit", "4.12")
    implementation("net.dv8tion:JDA:4.2.0_168")
}
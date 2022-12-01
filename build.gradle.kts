plugins {
    kotlin("jvm") version "1.6.0"
    id("com.diffplug.spotless") version "6.0.4"
}

repositories {
    mavenCentral()
}

tasks {
    sourceSets {
        main {
            java.srcDirs("src")
        }
    }

    wrapper {
        gradleVersion = "7.3"
    }
}

configure<com.diffplug.gradle.spotless.SpotlessExtension> {
    kotlin {
        ktfmt()
        ktlint()
    }
}

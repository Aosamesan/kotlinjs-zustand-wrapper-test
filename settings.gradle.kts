plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
    kotlin("multiplatform") version "2.0.20" apply false
}
rootProject.name = "kotlin-zustand-wrapper"
include("testReactApp")

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
    versionCatalogs {
        create("kotlinWrappers") {
            from("org.jetbrains.kotlin-wrappers:kotlin-wrappers-catalog:${providers.gradleProperty("kotlin.wrapper.version").get()}")
        }
    }
}

plugins {
    kotlin("multiplatform")
}

repositories {
    mavenCentral()
}

kotlin {
    js {
        binaries.executable()
        browser {
            commonWebpackConfig {
                devServer?.port = 3000
                devServer?.open = false
                outputFileName = "main.js"
            }
        }
    }
    sourceSets {
        jsMain {
            dependencies {
                implementation(kotlin("stdlib-js"))
                implementation(kotlinWrappers.wrappers.react)
                implementation(kotlinWrappers.wrappers.react.dom)
                implementation(rootProject)
            }
        }
    }
}
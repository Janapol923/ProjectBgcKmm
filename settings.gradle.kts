import java.net.URI

pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://kotlin.bintray.com/kotlinx")
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id == "kotlin-multiplatform") {
                useModule("org.jetbrains.kotlin:kotlin-gradle-plugin:${requested.version}")
            }
            if (requested.id.id == "kotlinx-serialization") {
                useModule("org.jetbrains.kotlin:kotlin-serialization:${requested.version}")
            }
        }
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "ProjectBgcKmm"
include(":androidApp")
include(":shared")

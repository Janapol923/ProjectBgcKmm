plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("kotlinx-serialization")
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                //put your multiplatform dependencies here
                // KTOR
                // HTTP engine: that handles network requests.
                implementation("io.ktor:ktor-client-core:2.2.3")
                // It used for JSON serialization and deserialization settings and //is recommended for multiplatform projects
                implementation("io.ktor:ktor-client-serialization:2.2.3")
                //It is kotlinx.serialization, which is used for entity //serialization
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0")
                //It's for logging HTTP requests
                implementation("io.ktor:ktor-client-logging:2.2.3")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
            }
        }
        val commonTest by getting
        val androidMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-android:2.2.3")
                implementation("io.ktor:ktor-client-okhttp:2.2.3")
            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by getting {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)

            dependencies {
                implementation("io.ktor:ktor-client-darwin:2.2.3")
            }
        }
    }
}

android {
    namespace = "com.example.projectbgckmm"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
    }
}

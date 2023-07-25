plugins {
    id("com.android.application")
    //id("kotlinx-serialization")
    kotlin("android")
}

android {
    namespace = "com.example.projectbgckmm.android"
    compileSdk = 33
    defaultConfig {
        applicationId = "com.example.projectbgckmm.android"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.7"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":shared"))
    implementation("androidx.compose.ui:ui:1.4.3")
    implementation("androidx.compose.ui:ui-tooling:1.4.3")
    implementation("androidx.compose.ui:ui-tooling-preview:1.4.3")
    implementation("androidx.compose.foundation:foundation:1.4.3")
    implementation("androidx.compose.material:material:1.4.3")
    implementation("androidx.activity:activity-compose:1.7.1")

    implementation("androidx.navigation:navigation-compose:2.6.0")

    // AndroidX Lifecycle
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")

    // Network
    /*implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:4.11.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.11.0")*/

    //Coil for Images
    implementation("io.coil-kt:coil-compose:2.0.0-rc01")

    /*// KTOR
    // HTTP engine: that handles network requests.
    implementation("io.ktor:ktor-client-android:2.2.3")
    // It used for JSON serialization and deserialization settings and //is recommended for multiplatform projects
    implementation("io.ktor:ktor-client-serialization:2.2.3")
    //It is kotlinx.serialization, which is used for entity //serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0")
    //It's for logging HTTP requests
    implementation ("io.ktor:ktor-client-logging-jvm:2.2.3")*/
}

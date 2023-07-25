plugins {
    //trick: for the same plugin versions in all sub-modules
    id("com.android.application").version("8.0.0").apply(false)
    id("com.android.library").version("8.0.0").apply(false)
    //id("org.jetbrains.kotlin.android").version("1.7.10").apply(false)
    id("kotlinx-serialization").version("1.3.20").apply(true)

    kotlin("android").version("1.8.21").apply(false)
    kotlin("multiplatform").version("1.8.21").apply(false)
}

/*configurations {
    ktorDependecy
}

dependencies {
    ktorDependecy 'org.jetbrains.kotlin:kotlin-serialization:1.7.10'
}*/

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

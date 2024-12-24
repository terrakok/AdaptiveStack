plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.android.library)
    id("convention.publication")
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.compose)
}

group = "com.github.terrakok"
version = "1.0.0"

kotlin {
    jvmToolchain(11)
    androidTarget { publishLibraryVariants("release") }
    jvm()
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    js { browser() }
    wasmJs { browser() }

    sourceSets {
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
        }
    }
}

android {
    namespace = "com.github.terrakok"
    compileSdk = 35

    defaultConfig {
        minSdk = 21
    }
}

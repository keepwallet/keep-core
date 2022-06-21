import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("dev.icerock.moko.kswift") version "0.5.0"
}

val libName = "CoreCrypto"
version = "1.0"

kotlin {
    val xcFramework = XCFramework(libName)

    android()
    ios {
        binaries.framework(libName) {
            baseName = libName
            xcFramework.add(this)
        }
    }
    iosSimulatorArm64() {
        binaries.framework {
            baseName = libName
            xcFramework.add(this)
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":core-model"))
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting
        val androidTest by getting
        val iosMain by getting
        val iosTest by getting
    }
}

android {
    compileSdk = 32
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 28
        targetSdk = 32
    }
}
pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "KeepCore"
include(":androidApp")
include(":core-model")
include(":core-blockchain")
include(":core-crypto")

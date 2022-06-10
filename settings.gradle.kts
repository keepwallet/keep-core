pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "KeepCore"
include(":androidApp")
include(":shared")
include(":core-model")
include(":core-blockchain")

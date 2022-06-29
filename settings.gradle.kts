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
include(":blockchain-smartchain")
include(":core-data")
include(":core-ui")

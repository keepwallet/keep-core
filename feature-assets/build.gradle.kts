plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

repositories {
    google()
    mavenCentral()
}

android {
    compileSdk = 32

    defaultConfig {
        minSdk = 28
        targetSdk = 32

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.2.0"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(project(":core-blockchain"))
    implementation(project(":core-model"))
    implementation(project(":core-data"))
    implementation(project(":core-ui"))

    implementation("androidx.core:core-ktx:1.8.0")
    implementation("androidx.appcompat:appcompat:1.4.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.0")
    // Compose
    implementation("androidx.compose.ui:ui:1.3.0-alpha01")
    implementation("androidx.compose.material:material:1.3.0-alpha01")
    implementation("androidx.compose.material3:material3:1.0.0-alpha14")
    implementation("androidx.compose.material3:material3-window-size-class:1.0.0-alpha14")
    // Icons
    implementation("androidx.compose.material:material-icons-extended:1.3.0-alpha01")
    // Preview
    implementation("androidx.compose.ui:ui-tooling-preview:1.3.0-alpha01")
    api("androidx.compose.ui:ui-tooling-preview:1.3.0-alpha01")
    debugApi("androidx.compose.ui:ui-tooling:1.3.0-alpha01")
    debugApi ("androidx.customview:customview:1.2.0-alpha01")
    debugApi("androidx.customview:customview-poolingcontainer:1.0.0-rc01")
    // Tests
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}
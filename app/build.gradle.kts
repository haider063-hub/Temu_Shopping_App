plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.temu_app"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.temu_app"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.foundation.layout.android)
    implementation(libs.material)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.activity)
    dependencies {

        implementation(libs.androidx.core.ktx) // 1.13.0
        implementation(libs.material.v160)
        implementation(libs.glide)
        implementation(libs.androidx.cardview)
        implementation(libs.androidx.lifecycle.runtime.ktx)
        implementation(libs.androidx.lifecycle.viewmodel.ktx)
        implementation(libs.retrofit)
        implementation(libs.converter.gson)
        implementation(libs.kotlinx.coroutines.core)
        implementation(libs.kotlinx.coroutines.android)
        implementation (libs.androidx.preference)
        implementation(libs.androidx.core.ktx) // 1.13.0
        implementation(libs.androidx.appcompat) // 1.6.1
        implementation(libs.material) // 1.10.0
        implementation(libs.androidx.activity) // 1.7.0
        implementation(libs.androidx.constraintlayout) // 2.1.4
        implementation(libs.androidx.preference) // 1.2.0
        testImplementation(libs.junit) // 4.13.2
        androidTestImplementation(libs.androidx.junit) // 1.1.5
        androidTestImplementation(libs.androidx.espresso.core) // 3.5.1
    }
}
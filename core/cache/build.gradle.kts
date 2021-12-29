plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("kotlin-parcelize")
}

android {
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
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
        jvmTarget = Versions.java
    }
}

dependencies {

    /** Local */
    implementation(project(CoreModules.utils))
    implementation(project(CoreModules.styles))

    /** Kotlin */
    implementation(Dependencies.kotlinCoreKtx)
    implementation(Dependencies.javaSerializationJson)
    implementation(Dependencies.kotlinxSerializationJson)

    /** Hilt */
    implementation(Dependencies.hilt)
    kapt(Dependencies.hiltCompiler)

    /** Coroutines */
    implementation(Dependencies.coroutines)

    /** 3rd Party */
    implementation(Dependencies.gson)
}

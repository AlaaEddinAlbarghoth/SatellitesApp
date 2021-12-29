plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs.kotlin")
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
    buildFeatures {
        dataBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = Versions.java
    }
    kapt {
        correctErrorTypes = true
    }
}

dependencies {

    /** Local */
    implementation(project(CoreModules.cache))
    implementation(project(CoreModules.utils))
    implementation(project(CoreModules.styles))

    /** Kotlin */
    implementation(Dependencies.kotlinCoreKtx)

    /** Android */
    implementation(Dependencies.material)
    implementation(Dependencies.appCompat)
    implementation(Dependencies.constraintLayout)

    /** Hilt */
    implementation(Dependencies.hilt)
    implementation(Dependencies.hiltViewModel)
    kapt(Dependencies.hiltCompiler)
    kapt(Dependencies.hiltViewModelCompiler)

    /** Navigation */
    implementation(Dependencies.navUi)
    implementation(Dependencies.navFragment)

    /** LifeCycle */
    implementation(Dependencies.lifecycleRuntime)

    /** 3rd Party */
    implementation(Dependencies.lottie)
}

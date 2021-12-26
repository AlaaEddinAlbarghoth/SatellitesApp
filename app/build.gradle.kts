plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        applicationId = "com.alaaeddinalbarghoth.satellites"
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName

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
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    /** Local */
    implementation(project(CoreModules.cache))
    implementation(project(CoreModules.styles))
    implementation(project(CoreModules.utils))
    implementation(project(FeaturesModules.main))

    /** Kotlin */
    implementation(Dependencies.kotlinCoreKtx)

    /** Android */
    implementation(Dependencies.material)
    implementation(Dependencies.appCompat)
    implementation(Dependencies.constraintLayout)

    /** LifeCycle */
    implementation(Dependencies.lifecycleRuntime)
    implementation(Dependencies.lifecycleViewModel)

    /** Hilt */
    implementation(Dependencies.hilt)
    implementation(Dependencies.hiltViewModel)
    kapt(Dependencies.hiltCompiler)
    kapt(Dependencies.hiltViewModelCompiler)

    /** 3rd Party */
    implementation(Dependencies.timber)

    /** Test */
    testImplementation(Dependencies.junit)
    androidTestImplementation(Dependencies.androidJUnit)
    androidTestImplementation(Dependencies.espresso)
}

object Dependencies {

    /** region Kotlin */
    val kotlinCoreKtx by lazy { "androidx.core:core-ktx:${Versions.kotlinCoreKtx}" }
    val kotlinxSerializationJson by lazy {
        "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.kotlinxSerializationJson}"
    }
    /** endregion */

    /** region Android */
    val appCompat by lazy { "androidx.appcompat:appcompat:${Versions.appCompat}" }
    val material by lazy { "com.google.android.material:material:${Versions.material}" }
    val constraintLayout by lazy { "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}" }
    /** endregion */

    /** region LifeCycle */
    val lifecycleViewModel by lazy { "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}" }
    val lifecycleLivedata by lazy { "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}" }
    val lifecycleRuntime by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}" }
    val lifecycleSavedState by lazy { "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.lifecycle}" }
    /** endregion */

    /** region Coroutines */
    val coroutines by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}" }
    /** endregion */

    /** region Navigation */
    /** endregion */

    /** region Hilt */
    val hilt by lazy { "com.google.dagger:hilt-android:${Versions.hiltAndroidPlugin}" }
    val hiltViewModel by lazy { "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hiltViewModel}" }
    val hiltCompiler by lazy { "com.google.dagger:hilt-android-compiler:${Versions.hiltAndroidPlugin}" }
    val hiltViewModelCompiler by lazy { "androidx.hilt:hilt-compiler:${Versions.hiltViewModelCompiler}" }
    /** endregion */

    /** region 3rd Party */
    val gson by lazy { "com.google.code.gson:gson:${Versions.gson}" }
    val timber by lazy { "com.jakewharton.timber:timber:${Versions.timber}" }
    /** endregion */

    /** region Test */
    val junit by lazy { "junit:junit:${Versions.jUnit}" }
    val androidJUnit by lazy { "androidx.test.ext:junit:${Versions.androidJUnit}" }
    val espresso by lazy { "androidx.test.espresso:espresso-core:${Versions.espresso}" }
    /** endregion */
}

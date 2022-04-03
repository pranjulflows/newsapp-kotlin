import org.gradle.kotlin.dsl.provideDelegate

/**
 * To define plugins
 */
object BuildPlugins {
    val android by lazy { "com.android.tools.build:gradle:${Versions.gradlePlugin}" }
    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinGradlePlugin}" }
    val navigation by lazy { "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigationArgs}" }
    val hilt by lazy { "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt_version}" }
}

/**
 * To define dependencies
 */
object Dependency {
    val androidxCore by lazy { "androidx.core:core-ktx:${Versions.coreKtx}" }
    val appCompat by lazy { "androidx.appcompat:appcompat:${Versions.appCompat}" }
    val legacySupport by lazy { "androidx.legacy:legacy-support-v4:${Versions.legacySupport}" }
    val constraintLayout by lazy { "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}" }

    //navigation component
    val navigationUi by lazy { "androidx.navigation:navigation-ui-ktx:${Versions.nav_version}" }
    val navigationFragment by lazy { "androidx.navigation:navigation-fragment-ktx:${Versions.nav_version}" }

    //glide
    val glide by lazy { "com.github.bumptech.glide:glide:${Versions.glide_version}" }
    val glideCompiler by lazy { "com.github.bumptech.glide:compiler:${Versions.glide_version}" }

    // custom tabs
    val browserForCustomTabs by lazy { "androidx.browser:browser:${Versions.customTabs}" }

    //responsive size
    val sdp by lazy { "com.intuit.sdp:sdp-android:${Versions.sdp}" }

    //Lifecycle
    val lifecycleExtensions by lazy { "android.arch.lifecycle:extensions:${Versions.lifecycle_extensions}" }
    val dataBinding by lazy { "com.android.databinding:compiler:${Versions.dataBindingCompiler}" }

    //network
    val gson by lazy { "com.google.code.gson:gson:${Versions.gson}" }
    val okhttp3 by lazy { "com.squareup.okhttp3:okhttp:${Versions.okhttp3}" }
    val retrofit by lazy { "com.squareup.retrofit2:retrofit:${Versions.retrofit}" }
    val converterGson by lazy { "com.squareup.retrofit2:converter-gson:${Versions.retrofit}" }
    val kotlinConverter by lazy { "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Versions.kotlinx_serialization_converter}" }

    //interceptor
    val okhttpInterceptor by lazy { "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp3}" }

    //hilt

    val hilt by lazy {"com.google.dagger:hilt-android:${Versions.hilt_version}"}
    val hilt_compiler by lazy {"com.google.dagger:hilt-compiler:${Versions.hilt_version}"}
}

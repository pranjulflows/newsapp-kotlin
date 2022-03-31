plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}


android {
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        applicationId = "com.pranjul.newsapp"
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    packagingOptions {
        resources.excludes.add("META-INF/*")
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField(
                "String",
                "API_URL",
                "\"http://suthar.softradixtechnologies.com/api/\""
            )
        }

        getByName("debug") {
            buildConfigField(
                "String",
                "API_URL",
                "\"http://suthar.softradixtechnologies.com/api/\""
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    sourceSets {
        named("main") {
            java.srcDirs("build/generated/source/navigation-args")
        }
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }

    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    implementation(Dependency.androidxCore)
    implementation(Dependency.appCompat)
    implementation(Dependency.constraintLayout)
    implementation(Dependency.legacySupport)
    //responsive size
    implementation(Dependency.sdp)

    //navigation component
    implementation(Dependency.navigationFragment)
    implementation(Dependency.navigationUi)

    //Lifecycle
    implementation(Dependency.lifecycleExtensions)
    implementation(Dependency.dataBinding)

    //network
    implementation(Dependency.retrofit)
    implementation(Dependency.kotlinConverter)

    implementation(Dependency.converterGson)
    implementation(Dependency.gson)
    implementation(Dependency.okhttp3)

    //interceptor
    implementation(Dependency.okhttpInterceptor)
    //glide
    implementation(Dependency.glide)
    kapt(Dependency.glideCompiler)

    //hilt
    implementation(Dependency.hilt)
    kapt(Dependency.hilt_compiler)
}
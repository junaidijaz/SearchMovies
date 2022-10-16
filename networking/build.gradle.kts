plugins {
    id(BuildPlugins.androidLibrary)
    id(BuildPlugins.kotlinAndroidJB)
    id(BuildPlugins.kotlinKapt)
    id(BuildPlugins.androidHilt)
}

android {
    compileSdk = AndroidSdk.compile

    defaultConfig {
        minSdk = AndroidSdk.min
        targetSdk = AndroidSdk.target
        testInstrumentationRunner = AndroidClient.testRunner
        consumerProguardFiles("consumer-rules.pro")

    }

    buildTypes {
        release {
            isMinifyEnabled = false
            buildConfigField("String", "BASE_URL", Releases.releaseUrl)
            buildConfigField("String", "MOVIE_API_KEY", Releases.movieApiKey)
            buildConfigField("double", "VERSION_NAME", AndroidClient.versionName)
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        debug {
            buildConfigField("String", "BASE_URL", Releases.stagingUrl)
            buildConfigField("String", "MOVIE_API_KEY", Releases.movieApiKey)
            buildConfigField("double", "VERSION_NAME", AndroidClient.versionName)
        }

    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    testImplementation(TestLibraries.junit4)
    androidTestImplementation(TestLibraries.testExtJunit)
    androidTestImplementation(TestLibraries.espressoCore)

    implementation(Libraries.hilt)
    kapt(Libraries.hiltAndroidCompilerKtx)

    api(Libraries.okHttpLoggingInterceptor)
    api(Libraries.okHttp)
    api(Libraries.retrofit)
    api(Libraries.retrofitMoshi)
    api(Libraries.moshi)
    api(Libraries.moshiKotlin)



}

kapt {
    correctErrorTypes = true
}


plugins {
    id(BuildPlugins.androidLibrary)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinKapt)
    id(BuildPlugins.androidHilt)
    id(BuildPlugins.kotlinParcelize)
    id(BuildPlugins.pluginSafeArgs)
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


    implementation(Libraries.ktxCore)
    implementation(Libraries.appCompat)
    implementation(Libraries.material)
    implementation(Libraries.constraintLayout)

    api(Libraries.navigationFragment)
    api(Libraries.navigationUi)

    testImplementation(TestLibraries.junit4)
    androidTestImplementation(TestLibraries.testExtJunit)
    androidTestImplementation(TestLibraries.espressoCore)

    implementation(Libraries.hilt)
    kapt(Libraries.hiltAndroidCompilerKtx)

    implementation(Libraries.viewModel)
    implementation(Libraries.lifeCycleRuntime)
    implementation(Libraries.activityKtx)
    kapt(Libraries.lifecycleCompiler)

    implementation(Libraries.ssp)
    implementation(Libraries.sdp)

    implementation(Libraries.glide)
    implementation(Libraries.swipeRefresh)

    implementation(Libraries.exoPlayer)
    implementation(Libraries.exoDash)
    implementation(Libraries.exoHls)
    implementation(Libraries.exoUi)


    implementation(project(path = SubModule.dataMoviesRepository))
    implementation(project(path = SubModule.dataCommon))
    implementation(project(path = SubModule.presentationCommon))
}
plugins {
    id(BuildPlugins.androidLibrary)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinKapt)
}

android {
    compileSdk = AndroidSdk.compile

    defaultConfig {
        minSdk = AndroidSdk.min
        targetSdk = AndroidSdk.target

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
}

dependencies {


    implementation(Libraries.hilt)
    kapt(Libraries.hiltAndroidCompilerKtx)

    androidTestImplementation(TestLibraries.espressoCore)
    testImplementation(TestLibraries.junit4)
    testImplementation(TestLibraries.testExtJunit)

    implementation(project(path = SubModule.networking))
    implementation(project(path = SubModule.dataMoviesRepository))
    implementation(project(path = SubModule.dataCommon))


}
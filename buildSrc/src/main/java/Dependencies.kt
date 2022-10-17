import java.text.SimpleDateFormat
import java.util.*

object Kotlin {
    const val standardLibrary = "1.5.3"
    const val coroutines = "1.5.2"
}


object AndroidSdk {
    const val min = 21
    const val compile = 32
    const val target = compile
}

object Releases {
    const val stagingUrl = "\"https://api.themoviedb.org/3/\""
    const val releaseUrl = "\"https://api.themoviedb.org/3/\""
    const val movieApiKey = "\"0d29ebd34be0ecced656524e3ec07759\""
}

object AndroidClient {
    const val appId = "com.simulated.starzplay"
    const val versionCode = 1
    const val versionName = "1.0"
    const val multidexEnabled = true
    const val useSupportLibrary = true
    const val testRunner = "androidx.test.runner.AndroidJUnitRunner"
}

object BuildPlugins {
    object Versions {
        const val buildToolsVersion = "7.0.4"
        const val gradleVersion = "6.8"
        const val hilt = "2.44"
        const val gmsVersion = "4.3.10"
    }

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
    const val kotlinGradlePlugin =
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${Kotlin.standardLibrary}"
    const val androidApplication = "com.android.application"
    const val gmsGoogleService = "com.google.gms:google-services:${Versions.gmsVersion}"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinKapt = "kotlin-kapt"
    const val kapt = "kapt"
    const val kotlinParcelize = "kotlin-parcelize"
    const val androidHilt = "dagger.hilt.android.plugin"
    const val gmsGoogle = "com.google.gms.google-services"
    const val androidLibrary = "com.android.library"
    const val kotlinAndroidJB = "org.jetbrains.kotlin.android"
    const val daggerHilt = "com.google.dagger.hilt.android"
}

object Libraries {
    private object Versions {
        const val gson = "2.9.1"
        const val hilt = BuildPlugins.Versions.hilt
        const val appCompat = "1.5.1"
        const val constraintLayout = "2.1.4"
        const val recyclerView = "1.1.0"
        const val cardView = "1.0.0"
        const val material = "1.6.0"
        const val lifecycle = "2.5.1"
        const val annotations = "1.1.0"
        const val ktx = "1.7.0"
        const val lifeCycleKtx = "1.5.0"
        const val glide = "4.14.2"
        const val retrofit = "2.9.0"
        const val okHttpLoggingInterceptor = "4.10.0"
        const val roomVersion = "2.4.3"
        const val calibriVersion = "3.1.1"
        const val viewPumpVersion = "2.0.3"
        const val moshi = "1.13.0"
        const val okHttp = "4.9.0"
        const val navVersion = "2.5.2"
        const val spDimen = "1.1.0"

    }

    const val navigationFragment =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navVersion}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navVersion}"

    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Kotlin.standardLibrary}"
    const val activityKtx = "androidx.activity:activity-ktx:${Versions.lifeCycleKtx}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.lifeCycleKtx}"
    const val kotlinCoroutines =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Kotlin.coroutines}"
    const val kotlinCoroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Kotlin.coroutines}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val ktxCore = "androidx.core:core-ktx:${Versions.ktx}"
    const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}"
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val lifeCycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    const val cardView = "androidx.cardview:cardview:${Versions.cardView}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val androidAnnotations = "androidx.annotation:annotation:${Versions.annotations}"
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideAnnotationProcessor = "com.github.bumptech.glide:compiler:${Versions.glide}"
    const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCompilerKtx = "com.google.dagger:hilt-compiler:${Versions.hilt}"
    const val hiltAndroidCompilerKtx = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    const val calligraphy3 = "io.github.inflationx:calligraphy3:${Versions.calibriVersion}"
    const val viewPump = "io.github.inflationx:viewpump:${Versions.viewPumpVersion}"

    //    const val hiltViewModels = "androidx.hilt: hilt-lifecycle-viewmodel:${Versions.hiltViewModels}"
    const val retrofit = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val retrofitMoshi = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    const val moshi = "com.squareup.moshi:moshi:${Versions.moshi}"
    const val moshiKotlin = "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"
    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    const val okHttpLoggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.okHttpLoggingInterceptor}"
    const val roomDatabase = "androidx.room:room-runtime:${Versions.roomVersion}"
    const val roomDatabaseCompiler = "androidx.room:room-compiler:${Versions.roomVersion}"
    const val roomKtxCoroutines = "androidx.room:room-ktx:${Versions.roomVersion}"
    const val conflictGuava =
        "com.google.guava:listenablefuture:9999.0-empty-to-avoid-conflict-with-guava"
    const val gson =
        "com.google.code.gson:gson:${Versions.gson}"

    const val sdp = "com.intuit.ssp:ssp-android:${Versions.spDimen}"
    const val ssp = "com.intuit.sdp:sdp-android:${Versions.spDimen}"


}

object TestLibraries {
    private object Versions {
        const val junit4 = "4.13.1"
        const val mockk = "1.10.0"
        const val mockito = "4.0.0"
        const val robolectric = "4.4"
        const val kluent = "1.14"
        const val testRunner = "1.1.0"
        const val espressoCore = "3.4.0"
        const val espressoIntents = "3.1.0"
        const val testExtensions = "1.1.3"
        const val testRules = "1.1.0"
        const val hiltTesting = BuildPlugins.Versions.hilt
    }

    const val junit4 = "junit:junit:${Versions.junit4}"
    const val mockk = "io.mockk:mockk:${Versions.mockk}"
    const val mockito = "org.mockito.kotlin:mockito-kotlin:${Versions.mockk}"
    const val robolectric = "org.robolectric:robolectric:${Versions.robolectric}"
    const val kluent = "org.amshove.kluent:kluent:${Versions.kluent}"
    const val testRunner = "androidx.test:runner:${Versions.testRunner}"
    const val testRules = "androidx.test:rules:${Versions.testRules}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    const val espressoIntents =
        "androidx.test.espresso:espresso-intents:${Versions.espressoIntents}"
    const val testExtJunit = "androidx.test.ext:junit:${Versions.testExtensions}"
    const val hiltTesting = "com.google.dagger:hilt-android-testing:${Versions.hiltTesting}"
}

object SubModule {
    const val dataMoviesRepository = ":data:data-movies-repository"
    const val dataMoviesRemote = ":data:data-movies-remote"
    const val dataCommon = ":data:data-common"
    const val networking = ":networking"
    const val presentationCommon = ":presentation:presentation-common"
    const val presentationHome = ":presentation:presentation-home"
}


object DevLibraries {
    private object Versions {
        const val leakCanary = "2.5"
    }

    const val leakCanary = "com.squareup.leakcanary:leakcanary-android:${Versions.leakCanary}"
}

@Suppress("SimpleDateFormat")
fun getCurrentDayTime(): String {
    val timeCurrent = Date()
    val dateFormat = SimpleDateFormat("dd.MM.HH.mm")
    return dateFormat.format(timeCurrent)
}

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(BuildPlugins.androidApplication) version  "7.2.2" apply  false
    id(BuildPlugins.androidLibrary) version  "7.2.2" apply  false
    id(BuildPlugins.kotlinAndroidJB)  version  "1.7.10" apply  false
    id(BuildPlugins.daggerHilt)  version  "2.44" apply  false
}
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(BuildPlugins.androidGradlePlugin)
        classpath(BuildPlugins.kotlinGradlePlugin)
        classpath(BuildPlugins.navigationSafeArgsGradlePlugin)
//        classpath(BuildPlugins.gmsGoogleService)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
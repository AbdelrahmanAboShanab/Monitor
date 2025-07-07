import org.gradle.api.tasks.Delete
import org.gradle.authentication.http.BasicAuthentication

buildscript {
    val kotlin_version by extra("2.1.10")
    val work_version by extra("2.7.1")
    val kotlin_coroutines_version by extra("1.7.2")
    val nav_version by extra("2.6.0")
    val androidx_appcompat by extra("1.6.1")
    val androidx_core by extra("1.10.1")
    val constraint_layout_version by extra("2.1.4")
    val lifecycle_version by extra("2.8.7")
    val android_material by extra("1.9.0")
    val androidx_test_runner by extra("1.1.0-alpha03")
    val androidx_test_monitor by extra("1.1.0-alpha03")
    val androidx_espresso_core by extra("3.4.0-alpha02")
    val calligraphy_version by extra("3.0.0")
    val viewpump_version by extra("1.0.0")
    val dokka_version by extra("1.9.10")
    val retrofit by extra("2.9.0")
    val okhttp by extra("4.12.0")
    val stetho_version by extra("1.5.1")
    val assertj_core_version by extra("3.15.0")
    val firebaseMessagingVersion by extra("20.1.3")
    val firebaseCoreVersion by extra("17.2.3")
    val biometricVersion by extra("1.1.0")
    val rxjava2 by extra("2.2.21")
    val play_core_review by extra("2.0.1")
    val play_core_inapp_update by extra("2.1.0")
    val glide_version by extra("4.15.1")
    val mapbox_places_plugin_version by extra("0.12.0")
    val mapbox_navigation_sdk_ui_version by extra("0.42.6")
    val roomVersion by extra("2.6.1")
    val archLifecycleVersion by extra("2.1.0-alpha04")
    val androidxArchVersion by extra("2.0.0")
    val junit_version by extra("4.13.1")
    val mock_server_version by extra("4.3.1")
    val mockito_version by extra("3.2.4")

    dependencies {
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version")
        classpath("com.google.gms:google-services:4.4.2")
        classpath("com.google.firebase:firebase-crashlytics-gradle:3.0.2")

        // Mapbox
        classpath("com.mapbox.gradle.plugins:access-token:0.2.1")
        classpath("com.mapbox.gradle.plugins:sdk-registry:0.7.0")
        classpath("com.mapbox.mapboxsdk:mapbox-android-sdk-versions:1.1.3")
    }

    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven(url = "https://jitpack.io")
        maven(url = "https://maven.google.com")
        maven(url = "https://plugins.gradle.org/m2/")
        maven(url = "https://api.mapbox.com/downloads/v2/releases/maven") {
            authentication {
                create<BasicAuthentication>("basic")
            }
            credentials {
                username = "mapbox"
                password = project.findProperty("MAPBOX_DOWNLOADS_TOKEN") as String? ?: ""
            }
        }
    }
}

plugins {
    id("com.android.application") version "8.7.3" apply false
    id("com.android.library") version "8.7.3" apply false
    id("org.jetbrains.kotlin.android") version "2.1.10" apply false
    id("org.jetbrains.kotlin.plugin.serialization") version "2.1.10" apply false
    id("org.jetbrains.kotlin.plugin.compose") version "2.1.10" apply false
    id("com.google.devtools.ksp") version "2.1.10-1.0.31" apply false
    id("com.google.dagger.hilt.android") version "2.51.1" apply false
    id("com.google.firebase.crashlytics") version "3.0.3" apply false
}

// If you had ext.var in Groovy (not a recommended name), convert it properly:
extra["var"] = "3.4.2"

// Clean task
tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}
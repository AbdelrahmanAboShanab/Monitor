plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-parcelize")
    id("com.google.firebase.crashlytics")
    kotlin("plugin.compose")
    kotlin("plugin.serialization")
    id("com.google.devtools.ksp")
    id("dagger.hilt.android.plugin") //Hilt
}

android {
    namespace = "com.example.monitor"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.monitor"
        minSdk = 23
        targetSdk = 34
        versionCode = 520
        versionName = "3.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
//        consumerProguardFiles("consumer-rules.pro")

        buildConfigField(
            "String",
            "OPEN_WEATHER_BASE_URL",
            "http://api.openweathermap.org/data/2.5/"
        )
        buildConfigField(
            "String",
            "STRAVA_AUTHORIZE_URL",
            "https://www.strava.com/oauth/mobile/authorize"
        )

        buildConfigField(
            "String",
            "OPEN_WEATHER_BASE_URL",
            "\"http://api.openweathermap.org/data/2.5/\""
        )
        buildConfigField(
            "String",
            "STRAVA_AUTHORIZE_URL",
            "\"https://www.strava.com/oauth/mobile/authorize\""
        )
        buildConfigField("String", "STRAVA_TOKEN_URL", "\"https://www.strava.com/oauth/token\"")
        buildConfigField(
            "String",
            "STRAVA_REDIRECT_URI",
            "\"mahle://my-smartbike.com/oauth2redirect\""
        )
        buildConfigField("String", "STRAVA_REQUESTED_SCOPES", "\"activity:write,read_all\"")
        buildConfigField("String", "USER_AGENT_STRUCTURE", "\"ONE/%s (%s; build: %s; ANDROID %s)\"")
        buildConfigField("String", "APP_ALIAS", "\"ENDUSER\"")
        buildConfigField("String", "PLATFORM_NAME", "\"ANDROID\"")
        buildConfigField("String", "LANGUAGE_CATEGORY", "\"app\"")
        buildConfigField("String", "API_BASE_URL", "\"https://brand_placeholder/api/v1/\"")
        buildConfigField("String", "API_URL_PLACEHOLDER", "\"brand_placeholder\"")

        //TODO check what is this ????
//        val date = Date()
//        val formattedDate = SimpleDateFormat("ddMMyy").format(date)
//        archivesBaseName.set("Enduser_${android.defaultConfig.versionName}_code_${android.defaultConfig.versionCode}_${formattedDate}")
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

    flavorDimensions += "server"

    productFlavors {
        /**
         * DEVELOPMENT AWS Server
         */
        create("DEV") {
            dimension = "server"
            applicationIdSuffix = ".dev"
            buildConfigField("String", "API_URL_BRAND_DEFAULT", "\"dev.my-smartbike.com\"")
            buildConfigField(
                "String",
                "API_WEB_VIEW_ASSETS_BASE_URL",
                "\"https://dev.my-smartbike.com/api/v1/\""
            )
            buildConfigField("String", "EBIKE_CONNECTION_HELP_CONTENT_ID", "\"582\"")
            buildConfigField("String", "EBIKE_FIRMWARE_UPDATE_HELP_CONTENT_ID", "\"583\"")
            buildConfigField("String", "HEART_RATE_HELP_CONTENT_ID", "\"585\"")
            buildConfigField("String", "ASSISTANCE_HELP_CONTENT_ID", "\"586\"")
            buildConfigField("String", "EBIKE_LOCKING_HELP_CONTENT_ID", "\"604\"")
            // The application's ID, obtained during registration.
            buildConfigField("String", "STRAVA_CLIENT_ID", "\"30332\"")
        }

        /**
         * QA AWS Server
         */
        create("QA") {
            dimension = "server"
            applicationIdSuffix = ".qa"
            buildConfigField("String", "API_URL_BRAND_DEFAULT", "\"qa-api.my-smartbike.com\"")
            buildConfigField(
                "String",
                "API_WEB_VIEW_ASSETS_BASE_URL",
                "\"https://qa-api.my-smartbike.com/api/v1\""
            )
            buildConfigField("String", "EBIKE_CONNECTION_HELP_CONTENT_ID", "\"345\"")
            buildConfigField("String", "EBIKE_FIRMWARE_UPDATE_HELP_CONTENT_ID", "\"345\"")
            buildConfigField("String", "HEART_RATE_HELP_CONTENT_ID", "\"393\"")
            buildConfigField("String", "ASSISTANCE_HELP_CONTENT_ID", "\"394\"")
            buildConfigField("String", "EBIKE_LOCKING_HELP_CONTENT_ID", "\"586\"")
            // The application's ID, obtained during registration.
            buildConfigField("String", "STRAVA_CLIENT_ID", "\"30332\"")
        }

        /**
         * PRODUCTION AWS Server
         */
        create("PRO") {
            dimension = "server"
            buildConfigField("String", "API_URL_BRAND_DEFAULT", "\"my-smartbike.com\"")
            buildConfigField(
                "String",
                "API_WEB_VIEW_ASSETS_BASE_URL",
                "\"https://my-smartbike.com/api/v1/\""
            )
            buildConfigField("String", "EBIKE_CONNECTION_HELP_CONTENT_ID", "\"384\"")
            buildConfigField("String", "EBIKE_FIRMWARE_UPDATE_HELP_CONTENT_ID", "\"385\"")
            buildConfigField("String", "HEART_RATE_HELP_CONTENT_ID", "\"393\"")
            buildConfigField("String", "ASSISTANCE_HELP_CONTENT_ID", "\"394\"")
            buildConfigField("String", "EBIKE_LOCKING_HELP_CONTENT_ID", "\"411\"")
            // The application's ID, obtained during registration.
            buildConfigField("String", "STRAVA_CLIENT_ID", "\"45316\"")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }


    buildFeatures {
        viewBinding = true
        compose = true
        buildConfig = true
    }

}

dependencies {
    implementation("androidx.core:core-ktx:1.15.0")
    implementation("com.google.firebase:firebase-crashlytics-ktx:19.4.0")
    implementation("androidx.compose.material3:material3:1.2.1")

    val room_version = "2.7.1"
    implementation("androidx.room:room-runtime:$room_version")
    implementation("androidx.room:room-ktx:$room_version")
    ksp("androidx.room:room-compiler:$room_version")

    val lifecycle_version = "2.8.7"
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")

    val retrofit_version = "2.11.0"
    implementation("com.squareup.retrofit2:retrofit:$retrofit_version")
    implementation("com.squareup.retrofit2:converter-gson:$retrofit_version")
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")
    implementation("com.facebook.stetho:stetho-okhttp3:1.6.0")


    implementation("com.google.maps.android:maps-compose:6.4.1")
    implementation("com.google.maps.android:android-maps-utils:3.8.2")

    implementation("androidx.work:work-runtime-ktx:2.10.0")

    implementation("com.google.accompanist:accompanist-permissions:0.37.3")

    implementation("com.google.dagger:hilt-android:2.55")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")
    ksp("com.google.dagger:hilt-android-compiler:2.55")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("com.google.accompanist:accompanist-systemuicontroller:0.32.0")
    implementation("androidx.navigation:navigation-compose:2.8.8")

    implementation("androidx.datastore:datastore-core-android:1.1.7")
    implementation("androidx.datastore:datastore-preferences:1.1.7")

    testImplementation("junit:junit:4.13.2")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.10.1")
    testImplementation("io.mockk:mockk:1.13.8")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")

}